package com.example.recyclerviewwsr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewwsr.adapter.GradeAdapter
import com.example.recyclerviewwsr.adapter.MovieAdapter
import com.example.recyclerviewwsr.adapter.UserAdapter
import com.example.recyclerviewwsr.databinding.ActivityMovieDisplayBinding
import com.example.recyclerviewwsr.repository.Repository

class MovieDisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDisplayBinding
    private val movieAdapter by lazy { MovieAdapter() }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMovies.layoutManager = GridLayoutManager(this, 2)
        binding.rvMovies.adapter = movieAdapter

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPopularMovies()
        viewModel.movieResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { movieAdapter.setData(it.results) }
            }
            else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}