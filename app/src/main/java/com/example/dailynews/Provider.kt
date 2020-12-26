package com.example.dailynews

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://newsapi.org/v2/"
object Provider {
    val obj=Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
fun <T> cal(abc:Class<T>):T
{
    return  obj.create(abc)
}
}