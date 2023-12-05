package com.yeditepe.weekthreesectiontwo.weekten

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebServiceProvider{
    private val BASE_URL="https://fakestoreapi.com/"
    private val retrofitInstance= Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service by lazy{
        retrofitInstance.create(WebService::class.java)
    }

}