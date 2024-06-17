package com.example.gradlefix.netModule

import com.example.gradlefix.api.ItemsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://dragonball-api.com/api/characters/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ItemsApiService = retrofit.create(ItemsApiService::class.java)
}