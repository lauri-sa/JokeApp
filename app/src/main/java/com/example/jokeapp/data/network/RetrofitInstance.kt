package com.example.jokeapp.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton object to provide a single instance of Retrofit throughout the app.
// Using an object ensures that only one instance of Retrofit is created (Singleton pattern).
object RetrofitInstance {

    // The base URL for the API.
    // All API endpoints will be appended to this base URL.
    private const val BASE_URL = "https://v2.jokeapi.dev/joke/"

    // Logging interceptor to log HTTP request and response details.
    // Useful for debugging network interactions.
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        // Set the logging level to BODY to log request and response bodies.
        level = HttpLoggingInterceptor.Level.BODY
    }

    // OkHttpClient is the HTTP client used by Retrofit to make network requests.
    // Here, we add the logging interceptor to the client to log network activity.
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // The Retrofit instance that provides an implementation of the JokeApi interface.
    // The 'lazy' keyword ensures that the instance is created only when it's first accessed.
    val api: JokeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeApi::class.java)
    }
}
