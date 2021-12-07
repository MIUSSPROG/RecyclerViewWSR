package com.example.recyclerviewwsr.api

import com.example.recyclerviewwsr.model.Grade
import com.example.recyclerviewwsr.model.GradePost
import com.example.recyclerviewwsr.model.Movie
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("api/v1/grades/")
    suspend fun getGrades(): Response<List<Grade>>

    @POST("api/v1/grade/")
    suspend fun  postGrade(@Body grade: GradePost) : Response<GradePost>

    @PUT("api/v1/grade/update/{id}")
    suspend fun  postGrade(@Body grade: GradePost, @Path("id") id: Int) : Response<GradePost>

    @DELETE("api/v1/{id}")
    suspend fun deleteGrade(@Path("id") id: Int) : Response<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/grade/")
    suspend fun postGradeUrl(
        @Field("number") number: Int,
        @Field("letter") letter: String
    ) : Response<Grade>

    @GET("{cat}")
    suspend fun getMovies(
        @Path("cat") category: String,
        @Query("api_key") api_key: String,
        @Query("language") lang: String,
        @Query("page") page: Int
    ) : Response<Movie>


}