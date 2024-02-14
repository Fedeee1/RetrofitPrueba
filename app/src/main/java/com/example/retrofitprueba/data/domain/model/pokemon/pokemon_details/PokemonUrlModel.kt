package com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonUrlModel(
    @SerializedName("id")
    val id : String,
    @SerializedName("sprites")
    val sprites : String,
    @SerializedName("weight")
    val weight : String,
    @SerializedName("height")
    val height : String,
    @SerializedName("abilities")
    val abilities : String
) : BaseModel()
