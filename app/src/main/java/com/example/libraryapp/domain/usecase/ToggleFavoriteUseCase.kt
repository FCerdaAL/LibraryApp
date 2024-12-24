package com.example.libraryapp.domain.usecase

import com.example.libraryapp.domain.repository.MovieRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int) {
        repository.toggleFavorite(movieId)
    }
}
