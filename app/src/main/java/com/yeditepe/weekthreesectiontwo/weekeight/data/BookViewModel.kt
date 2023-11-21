package com.yeditepe.weekthreesectiontwo.weekeight.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter

class BookViewModel() :ViewModel() {

    private var _bookdata= MutableStateFlow(BookDataProvider.getBookList())

    val uiState= _bookdata.asStateFlow()

    fun getBookById(id : Int):Book {
        return _bookdata.value.filter { it.id==id }.get(0)
    }
}