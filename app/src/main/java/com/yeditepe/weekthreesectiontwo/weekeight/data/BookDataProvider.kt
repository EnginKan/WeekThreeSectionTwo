package com.yeditepe.weekthreesectiontwo.weekeight.data

object BookDataProvider {
    private var _bookList= mutableListOf<Book>()
    init{
        for(i in 0..100)
        _bookList.add(Book(i,"title"+i,"Author "+i,BookType.Comedy.toString()))
            }

    fun getBookList():List<Book>{
        return _bookList;
    }
}