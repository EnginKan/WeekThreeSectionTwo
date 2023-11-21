package com.yeditepe.weekthreesectiontwo.weekeight.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme
import com.yeditepe.weekthreesectiontwo.weekeight.data.Book
import com.yeditepe.weekthreesectiontwo.weekeight.data.BookViewModel


object Routes{
    val route1= "booklist"
    val route2= "details"
}
@Composable
fun BookLineItem(book: Book,
navController: NavController){

    Row(horizontalArrangement = Arrangement.spacedBy(5.dp),
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .fillMaxWidth()
        .clickable {
            navController.navigate("${Routes.route2}/${book.id}")
        }) {
        Text(text = "${book.title}",
        style = MaterialTheme.typography.bodyLarge)
        Text(text = "${book.author}",
            style = MaterialTheme.typography.bodyMedium)

    }
}

@Composable
fun BookListScreen(model: BookViewModel
    ,navController: NavController){
    val uiState by model.uiState.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        items(uiState){
            book->
            BookLineItem(book = book, navController =navController )
        }
    }
}


@Composable
fun BookDetail(model: BookViewModel, id: Int,
navController: NavController){
    val book = model.getBookById(id)
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(5.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text ="${book.title}",
        style=MaterialTheme.typography.bodyLarge)
        Text(text = "${book.author}",
        style=MaterialTheme.typography.bodyMedium)
        Text(text = "${book.type}",
        style = MaterialTheme.typography.bodyMedium
        )
        Button(onClick = { navController.navigate(Routes.route1)}) {
            Text(text = "Turn to List")

        }

    }
}

@Composable
fun BookScreen(){
    val controller= rememberNavController()
    val model: BookViewModel= viewModel()
    NavHost(navController = controller, startDestination = Routes.route1){
        composable(route = Routes.route1){
            BookListScreen(model = model, navController =controller )
        }
        composable(route="${Routes.route2}/{bookid}",
        arguments = listOf(navArgument("bookid"){type= NavType.IntType})
        ){
            stack->
            val bookid= stack.arguments?.getInt("bookid",0)
            if (bookid != null) {
                BookDetail(model = model, id = bookid, navController = controller )
            }
        }


    }
}

@Preview
@Composable
fun BookScreenPreview(){
    WeekThreeSectionTwoTheme {
        BookScreen()

    }
}