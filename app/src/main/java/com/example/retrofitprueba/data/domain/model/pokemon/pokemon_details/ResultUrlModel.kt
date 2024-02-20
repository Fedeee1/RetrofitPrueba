package com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultUrlModel(
    val results: PokemonUrlModel
) : BaseModel()