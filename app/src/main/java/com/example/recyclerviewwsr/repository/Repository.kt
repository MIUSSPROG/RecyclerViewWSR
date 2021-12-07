package com.example.recyclerviewwsr.repository

import com.example.recyclerviewwsr.api.RetrofitInstance
import com.example.recyclerviewwsr.model.Grade
import com.example.recyclerviewwsr.model.GradePost
import com.example.recyclerviewwsr.model.Movie
import com.example.recyclerviewwsr.utils.Constants.Companion.API_KEY
import retrofit2.Response

class Repository {

    suspend fun getGrades(): Response<List<Grade>>{
        return RetrofitInstance.api.getGrades()
    }

    suspend fun getPopularMovies(): Response<Movie>{
        return RetrofitInstance.api2.getMovies("popular", API_KEY, "ru-RU", 1)
    }

    suspend fun createGrade(grade: GradePost) : Response<GradePost>{
        return RetrofitInstance.api.postGrade(grade)
    }
}