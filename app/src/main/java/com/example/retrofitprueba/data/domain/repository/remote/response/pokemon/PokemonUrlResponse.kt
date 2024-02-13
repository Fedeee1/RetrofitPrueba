package com.example.retrofitprueba.data.domain.repository.remote.response.pokemon

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serial

data class PokemonUrlResponse(
    @SerializedName("id")
    val id : String,
    @SerializedName("sprites")
    val sprites : PokemonSpritesResponse,
    @SerializedName("weight")
    val weight : String,
    @SerializedName("height")
    val height : String,
    @SerializedName("abilities")
    val abilities : List<PokemonAbilitiesResponse>
)
