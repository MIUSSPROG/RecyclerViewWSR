package com.example.recyclerviewwsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewwsr.databinding.ActivityPostBinding
import com.example.recyclerviewwsr.model.Grade
import com.example.recyclerviewwsr.model.GradePost
import com.example.recyclerviewwsr.repository.Repository
import com.example.recyclerviewwsr.utils.prefs

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.btnCreateGrade.setOnClickListener {
            viewModel.createGrade(GradePost(number = 12, letter = "e", profile = 2))
            viewModel.gradeResponse.observe(this, Observer { response ->
                if (response.isSuccessful){
                    Toast.makeText(this, response.body().toString(), Toast.LENGTH_SHORT ).show()
                }
                else{
                    Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
                }
            })
        }

        if (prefs.myLogin.isNotEmpty()){
            binding.etLogin.setText(prefs.myLogin)
        }

        binding.btnSaveState.setOnClickListener {
            prefs.myLogin = binding.etLogin.text.toString()
        }
    }
}