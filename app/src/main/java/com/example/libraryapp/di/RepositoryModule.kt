package com.example.libraryapp.di

import com.example.libraryapp.data.repository.MovieRepositoryImpl
import com.example.libraryapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(impl: MovieRepositoryImpl): MovieRepository = impl

    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}
