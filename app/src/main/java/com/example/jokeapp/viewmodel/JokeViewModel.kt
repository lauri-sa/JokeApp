package com.example.jokeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokeapp.data.network.RetrofitInstance
import kotlinx.coroutines.launch
import com.example.jokeapp.data.model.Joke

class JokeViewModel : ViewModel() {
    private val _joke = MutableLiveData<Joke?>(null)
    val joke: LiveData<Joke?> = _joke

    fun fetchProgrammingJoke() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProgrammingJoke()
                _joke.value = response // Update LiveData with fetched joke
                Log.d("JokeViewModel", "Fetched programming joke: ${response.joke}")
            } catch (e: Exception) {
                Log.e("JokeViewModel", "Error fetching joke", e)
            }
        }
    }

    fun fetchMiscJoke() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getMiscJoke()
                _joke.value = response // Update LiveData with fetched joke
                Log.d("JokeViewModel", "Fetched misc joke: ${response.joke}")
            } catch (e: Exception) {
                Log.e("JokeViewModel", "Error fetching joke", e)
            }
        }
    }

    fun fetchPunJoke() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPunJoke()
                _joke.value = response // Update LiveData with fetched joke
                Log.d("JokeViewModel", "Fetched pun joke: ${response.joke}")
            } catch (e: Exception) {
                Log.e("JokeViewModel", "Error fetching joke", e)
            }
        }
    }
}