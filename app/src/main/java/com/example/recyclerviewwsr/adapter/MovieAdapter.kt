package com.example.recyclerviewwsr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewwsr.databinding.ItemGradeBinding
import com.example.recyclerviewwsr.databinding.ItemMovieBinding
import com.example.recyclerviewwsr.model.Result
import com.example.recyclerviewwsr.utils.Constants.Companion.IMAGE_BASE

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies = emptyList<Result>()

    fun setData(input: List<Result>){
        movies = input
        notifyDataSetChanged()
    }

    class MovieViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        with(holder.binding){
            tvTitle.text = movie.title
            Glide.with(imgvMovie.context)
                .load(IMAGE_BASE + movie.poster_path)
                .into(imgvMovie)
        }
    }

    override fun getItemCount(): Int = movies.size
}