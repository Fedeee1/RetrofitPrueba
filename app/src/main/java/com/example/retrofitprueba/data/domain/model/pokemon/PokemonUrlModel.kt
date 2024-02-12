package com.example.retrofitprueba.data.domain.model.pokemon

import com.example.retrofitprueba.data.domain.model.BaseModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serial

@Parcelize
data class PokemonUrlModel(
    @SerializedName("id")
    val id : Int,
    @SerializedName("sprites")
    val sprites : String,
    @SerializedName("weight")
    val weight : Double,
    @SerializedName("height")
    val height : Double,
    @SerializedName("abilities")
    val abilities : List<String>
) : BaseModel()
