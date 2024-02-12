package com.example.retrofitprueba.data.domain.repository.remote.response.pokemon

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class PokemonSpritesResponse(
    @SerializedName("front_default")
    val front_default : String
)
