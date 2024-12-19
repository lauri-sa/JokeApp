package com.example.jokeapp.data.network

import com.example.jokeapp.data.model.Joke
import retrofit2.http.GET

// Retrofit interface defining the API endpoints for fetching joke data.
// Retrofit automatically generates the implementation for this interface.
interface JokeApi {

    // The 'suspend' keyword indicates that this function is designed for use with coroutines,
    // allowing it to be called asynchronously without blocking the main thread.
    @GET("Programming?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single")
    suspend fun getProgrammingJoke(): Joke

    @GET("Miscellaneous?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single")
    suspend fun getMiscJoke(): Joke

    @GET("Pun?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single")
    suspend fun getPunJoke(): Joke
}