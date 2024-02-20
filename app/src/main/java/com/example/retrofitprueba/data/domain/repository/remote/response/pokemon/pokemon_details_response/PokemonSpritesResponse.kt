package com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_details_response

import com.google.gson.annotations.SerializedName

data class PokemonSpritesResponse(
    @SerializedName("front_default")
    val front_default : String,
    @SerializedName("front_shiny")
    val front_shiny: String,
    @SerializedName("back_default")
    val back_default: String
)
