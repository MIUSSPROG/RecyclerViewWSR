package com.example.recyclerviewwsr.api

import com.example.recyclerviewwsr.utils.Constants.Companion.BASE_URL
import com.example.recyclerviewwsr.utils.Constants.Companion.MOVIE_BASE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val interceptor = HttpLoggingInterceptor()

    private val retrofit by lazy {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder() .addNetworkInterceptor(interceptor)
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    private val retrofit2 by lazy {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder() .addNetworkInterceptor(interceptor)
        Retrofit.Builder()
            .baseUrl(MOVIE_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    val api2: ApiService by lazy {
        retrofit2.create(ApiService::class.java)
    }

}