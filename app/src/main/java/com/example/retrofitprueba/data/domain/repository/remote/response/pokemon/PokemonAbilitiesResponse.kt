package com.example.retrofitprueba.data.domain.repository.remote.response.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonAbilitiesResponse(
    @SerializedName("ability")
    val ability : PokemonAbilityNameResponse
)
