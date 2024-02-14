package com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_evolutions_response

import com.google.gson.annotations.SerializedName

data class PokemonEvolvesToSecondResponse(
    @SerializedName("evolves_to")
    val evolves_to : PokemonsEvolvesToSpeciesResponse
)
