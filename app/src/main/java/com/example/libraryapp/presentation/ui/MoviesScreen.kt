package com.example.libraryapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.libraryapp.domain.model.Movie
import com.example.libraryapp.presentation.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(viewModel: MoviesViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        if (uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        } else if (uiState.error != null) {
            Text(text = "Error: ${uiState.error}", modifier = Modifier.fillMaxSize())
        } else {
            MovieList(
                movies = uiState.movies,
                onFavoriteToggle = viewModel::toggleFavorite
            )
        }
    }
}

@Composable
fun MovieList(movies: List<Movie>, onFavoriteToggle: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(movies) { movie ->
            MovieItem(movie = movie, onFavoriteToggle = onFavoriteToggle)
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onFavoriteToggle: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
                Text(text = movie.overview, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = { onFavoriteToggle(movie.id) }) {
                Icon(
                    imageVector = if (movie.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null
                )
            }
        }
    }
}
