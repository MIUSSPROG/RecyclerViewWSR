package com.example.recyclerviewwsr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewwsr.model.Grade
import com.example.recyclerviewwsr.repository.Repository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse : MutableLiveData<Response<List<Grade>>> = MutableLiveData()

    fun getGrades(){
        viewModelScope.launch {
            val response = repository.getGrades()
            myResponse.value = response
        }
    }

}