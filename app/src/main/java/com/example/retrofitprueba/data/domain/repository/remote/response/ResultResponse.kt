package com.example.retrofitprueba.data.domain.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ResultResponse (
    @SerializedName("results")
    val results : List<PokemonResponse>,
    @SerializedName("totalResult")
    val totalResult: Int
)