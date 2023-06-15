package com.example.youthlete.model

data class Sports(
    val name: String,
    val kursus: String,
    val imageResId: Int,
    val desc: String,
    val courses: List<Course>
) : java.io.Serializable

data class Course(
    val name: String,
    val imageResId: Int
) : java.io.Serializable
