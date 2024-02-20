package com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_details_response

import com.google.gson.annotations.SerializedName

data class ResultUrlResponse(
    @SerializedName("results")
    val results: PokemonUrlResponse
)