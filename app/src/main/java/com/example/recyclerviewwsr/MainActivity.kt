package com.example.recyclerviewwsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewwsr.adapter.GradeAdapter
import com.example.recyclerviewwsr.adapter.UserAdapter
import com.example.recyclerviewwsr.databinding.ActivityMainBinding
import com.example.recyclerviewwsr.repository.Repository
import com.example.recyclerviewwsr.utils.Service

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val gradeAdapter by lazy { GradeAdapter() }
    private lateinit var service: Service
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        service = Service()
//        userAdapter = UserAdapter(service.getUsers())
//        binding.rvUsers.adapter = userAdapter

        binding.rvUsers.adapter = gradeAdapter

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getGrades()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { gradeAdapter.setData(it) }
//                response.body()?.forEach { item ->
//                    Log.d("My Response:" , item.toString())
//                }
            }
            else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }
}