package com.example.libraryapp.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String?,
    val isFavorite: Boolean = false
)