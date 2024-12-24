package com.example.libraryapp.domain.repository

import com.example.libraryapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(page: Int): Flow<List<Movie>>
    suspend fun toggleFavorite(movieId: Int)
}
