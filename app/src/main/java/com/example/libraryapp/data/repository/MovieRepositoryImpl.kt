package com.example.libraryapp.data.repository

import com.example.libraryapp.data.local.MovieDao
import com.example.libraryapp.data.local.entities.toDomain
import com.example.libraryapp.domain.model.Movie
import com.example.libraryapp.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val dao: MovieDao,
    private val dispatcher: CoroutineDispatcher
) : MovieRepository {

    override fun getPopularMovies(page: Int): Flow<List<Movie>> {
        return dao.getPopularMovies().map { movies ->
            movies.map { it.toDomain() }
        }
    }

    override suspend fun toggleFavorite(movieId: Int) {
        withContext(dispatcher) {
            val isFavorite = dao.isFavorite(movieId)
            dao.updateFavorite(movieId, !isFavorite)
        }
    }
}
