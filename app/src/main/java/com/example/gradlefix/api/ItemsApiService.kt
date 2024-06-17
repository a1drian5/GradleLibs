package com.example.gradlefix.api

import com.example.gradlefix.model.GuerreroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ItemsApiService {
    @GET
    suspend fun getGuerreroByUrl(@Url url: String): Response<GuerreroResponse>
}