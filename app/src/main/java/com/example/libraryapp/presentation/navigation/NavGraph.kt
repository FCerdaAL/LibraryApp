package com.example.libraryapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.libraryapp.presentation.features.movies.MoviesScreen
import com.example.libraryapp.presentation.features.details.MovieDetailsScreen
import com.example.libraryapp.presentation.features.search.SearchScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "movies") {
        composable("movies") {
            MoviesScreen(navController)
        }
        composable("details/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toInt() ?: -1
            MovieDetailsScreen(movieId, navController)
        }
        composable("search") {
            SearchScreen(navController)
        }
    }
}
