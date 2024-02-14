package com.example.retrofitprueba.data.domain.model.pokemon.pokemon_evolutions

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_evolutions_response.PokemonEvolvesToSecondResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonEvolvesToModel(
    @SerializedName("evolves_to")
    val evolves_to : String
) : BaseModel()
