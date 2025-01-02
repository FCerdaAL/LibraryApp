package com.example.libraryapp.presentation.features.movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.libraryapp.presentation.viewmodel.MoviesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(navController: NavController, viewModel: MoviesViewModel = hiltViewModel()) {
    val movies = viewModel.uiState.collectAsState().value

    Scaffold(topBar = {
        TopAppBar(title = { Text("Popular Movies") })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(movies) { movie ->
                    MovieItem(movie) {
                        navController.navigate("details/${movie.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = movie.overview, style = MaterialTheme.typography.bodyMedium)
        }
    }
}



