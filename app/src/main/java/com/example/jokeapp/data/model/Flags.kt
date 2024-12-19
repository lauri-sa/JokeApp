package com.example.jokeapp.data.model

import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("nsfw") val nsfw: Boolean,
    @SerializedName("religious") val religious: Boolean,
    @SerializedName("political") val political: Boolean,
    @SerializedName("racist") val racist: Boolean,
    @SerializedName("sexist") val sexist: Boolean,
    @SerializedName("explicit") val explicit: Boolean
)