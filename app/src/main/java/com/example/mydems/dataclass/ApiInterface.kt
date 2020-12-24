package com.example.mydems.dataclass

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface
{
    @GET("api/profile")
    fun getDetails(): Call<profile>
}