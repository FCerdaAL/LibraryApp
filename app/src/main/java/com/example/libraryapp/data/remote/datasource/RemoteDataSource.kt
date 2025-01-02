package com.example.libraryapp.data.remote.datasource

import com.example.libraryapp.data.remote.api.MovieApi
import com.example.libraryapp.domain.model.Movie

class RemoteDataSource(private val movieApi: MovieApi) {
    suspend fun getPopularMovies(apiKey: String): List<Movie> = movieApi.getPopularMovies(apiKey)

    suspend fun searchMovies(query: String, apiKey: String): List<Movie> = movieApi.searchMovies(query, apiKey)
}