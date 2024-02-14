package com.example.retrofitprueba.data.domain.repository.remote.response.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonAbilityNameResponse(
    @SerializedName("name")
    val name : String,
    @SerializedName("url")
    val url: String
)
