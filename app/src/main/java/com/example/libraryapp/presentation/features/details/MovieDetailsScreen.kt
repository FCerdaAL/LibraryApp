package com.example.libraryapp.presentation.features.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
//import java.lang.reflect.Modifier


@OptIn(ExperimentalMaterial3Api::class)
/*
@Composable
fun MovieDetailsScreen(
    movieId: Int,
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val movie = viewModel.getMovieDetails(movieId)

       // cambiar y considerar Notifier de compose!!!


    Scaffold(topBar = {
        TopAppBar(title = { Text("Movie Details") })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = movie.overview, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigateUp() }) {
                    Text("Back")
                }
            }
        }
    }
}
*/
@Composable
fun MovieDetailsScreen(
    movieId: Int,
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val movieState = viewModel.movie.collectAsState(initial = null)

    Scaffold(topBar = {
        TopAppBar(title = { Text("Movie Details") })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                movieState.value?.let { movie ->
                    Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = movie.overview, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                } ?: Text(text = "Loading...", style = MaterialTheme.typography.bodyMedium)

                Button(onClick = { navController.navigateUp() }) {
                    Text("Back")
                }
            }
        }
    }
}
