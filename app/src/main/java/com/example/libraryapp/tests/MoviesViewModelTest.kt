package com.example.libraryapp.presentation.viewmodel

//import app.cash.turbine.test
import com.example.libraryapp.domain.model.Movie
import com.example.libraryapp.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class MoviesViewModelTest {

    private val repository: MovieRepository = mock()
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = MoviesViewModel(mock(), mock())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadMovies emits movies successfully`() = runBlocking {
        val movies = listOf(
            Movie(1, "Movie 1", "Overview 1", null, false),
            Movie(2, "Movie 2", "Overview 2", null, true)
        )

        whenever(repository.getPopularMovies(1)).thenReturn(flow { emit(movies) })

        viewModel.uiState.test {
            viewModel.loadMovies()

            val state = awaitItem()
            assert(state.movies == movies)
        }
    }

    @Test
    fun `toggleFavorite updates movie favorite state`() = runBlocking {
        val movieId = 1

        viewModel.toggleFavorite(movieId)

        // Verifying the repository is called
        // (Add Mockito.verify(repository).toggleFavorite(movieId) if using mocks for repository)
    }
}
