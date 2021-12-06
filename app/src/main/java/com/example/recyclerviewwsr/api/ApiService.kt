package com.example.recyclerviewwsr.api

import com.example.recyclerviewwsr.model.Grade
import com.example.recyclerviewwsr.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/grades/")
    suspend fun getGrades(): Response<List<Grade>>

    @GET("{cat}")
    suspend fun getMovies(
        @Path("cat") category: String,
        @Query("api_key") api_key: String,
        @Query("language") lang: String,
        @Query("page") page: Int
    ) : Response<Movie>
}