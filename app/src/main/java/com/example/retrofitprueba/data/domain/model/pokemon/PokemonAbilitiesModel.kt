package com.example.retrofitprueba.data.domain.model.pokemon

import com.example.retrofitprueba.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilitiesModel(
    val name : String
) : BaseModel()
