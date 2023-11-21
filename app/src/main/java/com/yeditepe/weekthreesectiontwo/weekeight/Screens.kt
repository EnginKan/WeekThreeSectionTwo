package com.yeditepe.weekthreesectiontwo.weekeight

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

object Routes{
    val route1="rootone"
    val route2="roottwo"
}
@Composable
fun ScreenOne(onClick: ()->Unit){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
            Box(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)){
              Text(text = "1",
              style=MaterialTheme.typography.headlineLarge)
            }
        Button(onClick = onClick) {
            Text(text = "Go to Screen Two")

        }
    }
}
@Composable
fun ScreenTwo(onClick: ()->Unit){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.onPrimaryContainer)){
            Text(text = "2",
                style=MaterialTheme.typography.headlineLarge)
        }
        Button(onClick = onClick) {
            Text(text = "Go to Screen One")

        }
    }
}
@Composable
fun MainScreen(controller: NavHostController){

        NavHost(navController = controller, startDestination = Routes.route1 ){
            composable(route=Routes.route1){
                ScreenOne(onClick = {controller.navigate(Routes.route2)})
            }
            composable(route=Routes.route2){
                ScreenTwo(onClick = {controller.navigate(Routes.route1)})
            }

        }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview(){
    val controller= rememberNavController();
    WeekThreeSectionTwoTheme {

        MainScreen(controller = controller)
    }
}