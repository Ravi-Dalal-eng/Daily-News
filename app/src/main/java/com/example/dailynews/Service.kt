package com.example.dailynews

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


//076dc3a0f6b4449f9437b7e1aa474a48
        const val API_KEY="406dd049cf4c49cbb45a02ab45e29fc6"
interface Service {
    @GET("top-headlines?apiKey=$API_KEY")
fun getHeadLines(@Query("country") c :String,@Query("page") p :Int,@Query("category") a :String) : Call<News>

}
