package com.example.libraryapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String?,
    val isFavorite: Boolean
)

// Extensions for mapping between Entity and Domain model

fun MovieEntity.toDomain(): com.example.libraryapp.domain.model.Movie {
    return com.example.libraryapp.domain.model.Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        isFavorite = isFavorite
    )
}

fun com.example.libraryapp.domain.model.Movie.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        isFavorite = isFavorite
    )
}
