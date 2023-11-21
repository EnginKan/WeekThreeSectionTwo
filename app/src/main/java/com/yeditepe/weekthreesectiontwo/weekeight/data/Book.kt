package com.yeditepe.weekthreesectiontwo.weekeight.data

data class Book (
    val id: Int,
    val title: String,
    val author: String,
    val type: String
        )

enum class BookType(value: String){
    Horror("Horror"),
    ScienceFiction("science fiction"),
    Comedy("Comedy")
}