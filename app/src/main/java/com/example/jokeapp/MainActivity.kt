package com.example.jokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jokeapp.view.HomeScreen
import com.example.jokeapp.view.MiscJokeScreen
import com.example.jokeapp.view.ProgrammingJokeScreen
import com.example.jokeapp.view.PunJokeScreen
import com.example.jokeapp.viewmodel.JokeViewModel
import com.example.jokeapp.ui.theme.JokeAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokeAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation(viewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: JokeViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homeScreen") {
        composable( "homeScreen" ) { HomeScreen(navController) }
        composable( "programmingJokeScreen" ) { ProgrammingJokeScreen(navController, viewModel) }
        composable( "miscJokeScreen" ) { MiscJokeScreen(navController, viewModel) }
        composable( "punJokeScreen" ) { PunJokeScreen(navController, viewModel) }
    }
}