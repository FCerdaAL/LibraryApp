package com.example.libraryapp.domain.usecase

import com.example.libraryapp.domain.model.Movie
import com.example.libraryapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(page: Int): Flow<List<Movie>> {
        return repository.getPopularMovies(page)
    }
}