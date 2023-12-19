package com.yeditepe.weekthreesectiontwo.weektwelve.persistence

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgs
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

@ExperimentalMaterial3Api
@Composable
fun ColorListItem(color: MyColor,
controller: NavController){

    Card(onClick = { controller.navigate(Destination.DETAIL.name+"/${color._id}") },
    modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(color.hex_code.toColorInt()))
        .height(50.dp)
    ) {
        Text(text = color.hex_code)
    }

}
@ExperimentalMaterial3Api
@Composable
fun ColorListScreen(model: ColorViewModel,
                    controller: NavController){
    val data by rememberSaveable {
        mutableStateOf( model.all_color)
    }
    Column(){
        TextField(value = "", onValueChange ={model.filterByName(it) } )
    LazyColumn(){
        items(data!!){
            color->
            ColorListItem(color = color, controller = controller )
        }

    }
    }
}
@ExperimentalMaterial3Api
@Composable
fun ColorDetailScreen(id: Int,
                      model: ColorViewModel,
                      controller: NavController){
    val color=model.findById(id)
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Card(onClick = { /*TODO*/ },
        modifier = Modifier
            .background(color = Color(color!!.hex_code.toColorInt()))
            .height(50.dp)
            .fillMaxWidth()) {

        }
        Text(text = color!!.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = color!!.hex_code, style = MaterialTheme.typography.headlineLarge)
        Button(onClick = { controller.popBackStack() }) {

        }

    }
}
@ExperimentalMaterial3Api
@Composable
fun ColorAppMainScreen(model: ColorViewModel, controller: NavController){

    NavHost(navController = controller as NavHostController,
        startDestination =  Destination.MAIN.name){

        composable(Destination.MAIN.name){
            ColorListScreen(model = model, controller =controller )
        }
        composable(Destination.DETAIL.name+"/{color_id}",
            arguments = listOf(navArgument("color_id") { type = NavType.IntType })
        ){
            stack->
            ColorDetailScreen(model=model,
                id=stack.arguments!!.getInt("color_id") ,
                controller = controller)
        }

    }
}

enum class Destination(name: String){
    MAIN(name="main"),
    DETAIL(name="detail")
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ColorAppMainScreenPreview(){
    val c= rememberNavController()
    val model: ColorViewModel= viewModel()
    model.database = ColorDatabase.getInstance(LocalContext.current)
    WeekThreeSectionTwoTheme() {
        ColorAppMainScreen(model, c)

    }



}