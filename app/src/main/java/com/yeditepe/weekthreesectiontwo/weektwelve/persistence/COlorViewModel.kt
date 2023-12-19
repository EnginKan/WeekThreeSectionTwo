package com.yeditepe.weekthreesectiontwo.weektwelve.persistence

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ColorViewModel(var database: ColorDatabase): ViewModel() {

    private val _dao: MyColorDAO = database.getMyCalorDAO()

    private var _all_colors : List<MyColor>? = null

     val all_color: List<MyColor>?
        get() = _all_colors

    init{
        getDataFromDatabase()
    }
    private fun getDataFromDatabase(){
        viewModelScope.launch {
            _all_colors=_dao.getAll()
        }

    }
    fun filterByName(term: String){
        _all_colors=_all_colors!!.filter { it.name.contains(term) }
    }

    fun findById(id: Int):MyColor?{
        var color: MyColor?=null
        viewModelScope.launch {
            color=_dao.getColorByID(id)
        }
        return color
    }
}