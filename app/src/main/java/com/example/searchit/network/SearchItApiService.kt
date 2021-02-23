package com.example.searchit.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val SEARCH_API_KEY = "AIzaSyDt1Z28dvw2geVDdI77RgDxodro5GZlUY4"
private const val SEARCH_URL = "https://www.googleapis.com/customsearch"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(SEARCH_URL)
    .build()

interface SearchItApiService {
    @GET("v1")
    fun getProperties(): Call<String>
}

object SearchItApi {
    val retrofitService : SearchItApiService by lazy {
        retrofit.create(SearchItApiService::class.java)
    }
}