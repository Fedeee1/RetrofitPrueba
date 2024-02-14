package com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details

import com.example.retrofitprueba.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAbilityNameModel(
    val name : String
) : BaseModel()
