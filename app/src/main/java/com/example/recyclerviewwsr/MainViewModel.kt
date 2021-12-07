package com.example.recyclerviewwsr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewwsr.model.Grade
import com.example.recyclerviewwsr.model.GradePost
import com.example.recyclerviewwsr.model.Movie
import com.example.recyclerviewwsr.repository.Repository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse : MutableLiveData<Response<List<Grade>>> = MutableLiveData()
    val movieResponse: MutableLiveData<Response<Movie>> = MutableLiveData()
    val gradeResponse: MutableLiveData<Response<GradePost>> = MutableLiveData()

    fun getGrades(){
        viewModelScope.launch {
            val response = repository.getGrades()
            myResponse.value = response
        }
    }

    fun getPopularMovies(){
        viewModelScope.launch {
            val response = repository.getPopularMovies()
            movieResponse.value = response
        }
    }

    fun createGrade(grade: GradePost){
        viewModelScope.launch {
             gradeResponse.value = repository.createGrade(grade)
        }
    }

}