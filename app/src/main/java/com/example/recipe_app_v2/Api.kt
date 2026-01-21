package com.example.recipe_app_v2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val baseUrl = "https://www.themealdb.com/api/json/v1/1/"
private val retrofit = Retrofit.Builder().baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipieService = retrofit.create(Api::class.java)


interface Api {
    //in the get fucktion we will take the end point of the URL that is "categories.php"
    //and we will use this get suspend fucntion to get CategoriesResponse
    @GET("categories.php")
    suspend fun get(): CategoriesResponse
}