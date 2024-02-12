package com.example.retrofitprueba.data.domain.repository.remote.response

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
