package com.example.recyclerviewwsr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwsr.databinding.ItemGradeBinding
import com.example.recyclerviewwsr.model.Grade

class GradeAdapter() : RecyclerView.Adapter<GradeAdapter.GradeViewHolder>() {

    private var grades = emptyList<Grade>()

    fun setData(input: List<Grade>){
        grades = input
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGradeBinding.inflate(inflater, parent, false)
        return GradeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GradeViewHolder, position: Int) {
        val grade = grades[position]
        with(holder.binding){
            tvGradeNumberLetter.text = "${grade.number} ${grade.letter}"
            tvGradeProfile.text = grade.profile
        }
    }

    override fun getItemCount(): Int = grades.size

    class GradeViewHolder(val binding: ItemGradeBinding) : RecyclerView.ViewHolder(binding.root)

}