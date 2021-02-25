package com.example.searchit.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val SEARCH_API_KEY = "AIzaSyDt1Z28dvw2geVDdI77RgDxodro5GZlUY4"
private const val SEARCH_ENGINE = "1389c7d54d2167252"
private const val SEARCH_URL = "https://www.googleapis.com/customsearch/"

private val client = OkHttpClient.Builder()
    .addInterceptor(Interceptor {
        var request = it.request()
        val url = request.url().newBuilder()
            .addQueryParameter("key", SEARCH_API_KEY)
            .addQueryParameter("cx", SEARCH_ENGINE)
            .build()

        request = request.newBuilder().url(url).build()
        return@Interceptor it.proceed(request)
    }).build();

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(client)
    .baseUrl(SEARCH_URL)
    .build()

interface SearchItApiService {
    @GET("v1")
    fun getProperties(@Query("q") query: String): Deferred<ResultPage>
}

object SearchItApi {
    val retrofitService : SearchItApiService by lazy {
        retrofit.create(SearchItApiService::class.java)
    }
}