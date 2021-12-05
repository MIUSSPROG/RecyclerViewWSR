package com.example.recyclerviewwsr.repository

import com.example.recyclerviewwsr.api.RetrofitInstance
import com.example.recyclerviewwsr.model.Grade
import retrofit2.Response

class Repository {

    suspend fun getGrades(): Response<List<Grade>>{
        return RetrofitInstance.api.getGrades()
    }
}