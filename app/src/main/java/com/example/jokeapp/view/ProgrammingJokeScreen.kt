package com.example.jokeapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jokeapp.viewmodel.JokeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgrammingJokeScreen(navController: NavController, viewModel: JokeViewModel) {
    val joke = viewModel.joke.observeAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchProgrammingJoke()
    }

    CenterAlignedTopAppBar(
        title = { Text("Joke App") }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = joke.value?.joke ?: "Loading...",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = { navController.navigate("homeScreen") }) {
            Text("Return")
        }
    }
}