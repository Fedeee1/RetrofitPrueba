package com.example.retrofitprueba.data.domain.model.pokemon.pokemon_evolutions

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSpeciesNameModel (
    @SerializedName("name")
    val name: String
) : BaseModel()