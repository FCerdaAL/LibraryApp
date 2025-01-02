package com.example.libraryapp.data.local.datasource

import com.example.libraryapp.data.local.Dao.MovieDao
import com.example.libraryapp.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {
    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getMovies()

    suspend fun insertMovie(movie: MovieEntity) = movieDao.insertMovie(movie)

    suspend fun deleteMovie(movie: MovieEntity) = movieDao.deleteMovie(movie)
}