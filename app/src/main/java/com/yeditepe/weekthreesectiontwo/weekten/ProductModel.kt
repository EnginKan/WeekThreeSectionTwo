package com.yeditepe.weekthreesectiontwo.weekten

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okio.IOException

sealed interface UiState{
    data class Ready(var data: List<Product>): UiState
    object Loading: UiState
    object Error: UiState
}
class ProductModel():ViewModel() {
    var uiState:UiState by mutableStateOf(UiState.Loading)
    init{
        dowloadData()
    }
    fun dowloadData(){
        viewModelScope.launch {
            try {
                val data = WebServiceProvider.service.getAllProducts()
                uiState = UiState.Ready(data = data)
            }catch (e: IOException){
                uiState=UiState.Error
            }
        }
    }
}