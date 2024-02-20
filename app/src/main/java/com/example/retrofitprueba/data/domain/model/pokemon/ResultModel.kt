package com.example.retrofitprueba.data.domain.model.pokemon

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultModel(
    val results: List<PokemonModel>
) : BaseModel()