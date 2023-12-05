package com.yeditepe.weekthreesectiontwo.weekten

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yeditepe.weekthreesectiontwo.weeknine.Welcome

@Composable
fun MainScreen(model: ProductModel= viewModel()){
    val state=model.uiState

    when(state){
        is UiState.Loading-> WelcomeScreen()
        is UiState.Error->ErrorScreen()
        is UiState.Ready->ProductScreen(state.data)
    }
}

@Composable
fun ProductScreen(data: List<Product>) {

}

@Composable
fun ErrorScreen() {
    TODO("Not yet implemented")
}

@Composable
fun WelcomeScreen() {
    TODO("Not yet implemented")
}
