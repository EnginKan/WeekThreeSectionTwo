package com.yeditepe.weekthreesectiontwo.weeknine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

object Routes{
    val home="home"
    val settings="Setting"
    val payment="payment"
    val plans="plan"
    val welcome="Welcome"
    val user="User"
}

@Composable
fun Welcome(){


}

@Composable
fun Home(navController: NavController){
    Column(modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.spacedBy(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Home Screen")
        Button(onClick = { navController.navigate(Routes.settings) }) {
            Text(text = "Settings")

        }
        Button(onClick = { navController.navigate(Routes.user) }) {
            Icon(Icons.Filled.ArrowForward, contentDescription = "")
            Text(text = "User Info")
        }
        Button(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "")
            Text(text = "Previous")
                    }
    }
}

@Composable
fun Settings(navController: NavController){
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Settings Screen")
        Button(onClick = { navController.navigate(Routes.home) }) {
            Text(text = "Home Screen")

        }
        Button(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "")
            Text(text = "Previous")
        }
    }
}

@Composable
fun Payment(navController: NavController){
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Payment Screen")
        Button(onClick = { navController.navigate(Routes.plans) }) {
            Text(text = "Plans Screen")

        }
        Button(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "")
            Text(text = "Previous")
        }
    }
}

@Composable
fun Plans(navController: NavController){
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Plans Screen")
        Button(onClick = { navController.navigate(Routes.payment) }) {
            Text(text = "Payment Screen")

        }
        Button(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "")
            Text(text = "Previous")
        }
    }
}

@Composable
fun SetupNestedGraph(controller: NavHostController){


    NavHost(controller, startDestination = Routes.welcome){
       /* navigation(startDestination = Routes.home, route = Routes.welcome){
            composable(Routes.home){
                Home(controller)
            }
            composable(Routes.settings){
                Settings(controller)
            }

        }*/
        welcomeGraph(controller)
       /* navigation(startDestination = Routes.plans, route = Routes.user){
            composable(Routes.plans){
                Plans(controller)
            }
            composable(Routes.payment){
                Payment(controller)
            }

        }*/
        userGraph(controller)
    }
}


fun NavGraphBuilder.welcomeGraph(controller: NavHostController){
    navigation(startDestination = Routes.home, route = Routes.welcome){
        composable(Routes.home){
            Home(controller)
        }
        composable(Routes.settings){
            Settings(controller)
        }

    }


}
fun NavGraphBuilder.userGraph(controller: NavHostController){
    navigation(startDestination = Routes.plans, route = Routes.user){
        composable(Routes.plans){
            Plans(controller)
        }
        composable(Routes.payment){
            Payment(controller)
        }

    }
}
@ExperimentalMaterial3Api
@Composable
fun SetupNestedGraphWithBottomBar(controller: NavHostController){
    Scaffold(bottomBar = {
        BottomNavigation {
            val backStackEntry by controller.currentBackStackEntryAsState()
            val destination= backStackEntry?.destination
            BottomNavigationItem(
                selected = destination?.hierarchy?.any { it.route == Routes.home } == true,
                icon = {Icon(Icons.Filled.Home, contentDescription = "Welcome")},
                label = { Text("Welcome ") },
                onClick = { controller.navigate(Routes.welcome) },
            )
            BottomNavigationItem(
                selected = destination?.hierarchy?.any { it.route == Routes.user } == true,
                icon = {Icon(Icons.Filled.Person, contentDescription = "User")},
                label = { Text("User ") },
                onClick = { controller.navigate(Routes.user) },
            )
            
        }
        
    }) {
        innerPadding->
        NavHost(controller, startDestination = Routes.welcome, modifier = Modifier.padding(innerPadding)){

            welcomeGraph(controller)

            userGraph(controller)
        }

    }
}
@ExperimentalMaterial3Api
@Preview(showSystemUi = true)
@Composable
fun SetupNestedGraphPreview(){
    WeekThreeSectionTwoTheme() {
        val controller= rememberNavController()
        SetupNestedGraphWithBottomBar(controller)

    }
}
