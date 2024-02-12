package com.example.retrofitprueba.data.domain.model

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("results")
    val results: List<PokemonModel>
)