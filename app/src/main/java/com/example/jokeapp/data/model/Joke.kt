package com.example.jokeapp.data.model

import com.example.jokeapp.data.model.Flags
import com.google.gson.annotations.SerializedName

data class Joke (
    @SerializedName("error") val error: Boolean,
    @SerializedName("category") val category: String,
    @SerializedName("type") val type: String,
    @SerializedName("joke") val joke: String,
    @SerializedName("flags") val flags: Flags,
    @SerializedName("id") val id: Int,
    @SerializedName("safe") val safe: Boolean,
    @SerializedName("lang") val lang: String
)