package com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonUrlModel(
    val id : String,
    val sprites : String,
    val weight : String,
    val height : String,
    val abilities : String
) : BaseModel()
