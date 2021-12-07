package com.example.recyclerviewwsr.model

import com.google.gson.annotations.SerializedName

data class Grade(
    val id: Int,
    val number: Int,
    val letter: String,
    @SerializedName("grade_profile")
    val profile: String
)

data class GradePost(
    val number: Int,
    val letter: String,
    val profile: Int
)