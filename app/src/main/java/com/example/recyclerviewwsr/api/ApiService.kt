package com.example.recyclerviewwsr.api

import com.example.recyclerviewwsr.model.Grade
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/grades/")
    suspend fun getGrades(): Response<List<Grade>>
}