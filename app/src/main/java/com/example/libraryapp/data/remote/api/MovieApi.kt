/*
package com.example.libraryapp.data.remote.api

import com.example.libraryapp.domain.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("ed5507f5ab35e08cdb447c810f41e070") apiKey: String): List<Movie>

    @GET("search/movie")
    suspend fun searchMovies(@Query("query") query: String, @Query("ed5507f5ab35e08cdb447c810f41e070") apiKey: String): List<Movie>
}




*/

package com.example.libraryapp.data.remote.api

import com.example.libraryapp.domain.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): List<Movie>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String
    ): List<Movie>
}

