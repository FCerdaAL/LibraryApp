package com.example.libraryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
    abstract fun movieDao(): MovieDao
}