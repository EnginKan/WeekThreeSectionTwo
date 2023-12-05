package com.yeditepe.weekthreesectiontwo.weekten

import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("/products")
    suspend fun getAllProducts(): List<Product>

    @GET("/products/{id}")
    suspend fun getProductByID(@Path("id") id:Int): Product


}