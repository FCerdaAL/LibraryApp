package com.example.libraryapp.domain.usecase

import com.example.libraryapp.domain.model.Movie
import com.example.libraryapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(query: String): Flow<List<Movie>> = repository.searchMovies(query)
}