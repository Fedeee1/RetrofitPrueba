package com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemonurl

import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse

class PokemonUrlMapper : ResponseMapper<PokemonUrlResponse, PokemonUrlModel> {
    override fun fromResponse(response: PokemonUrlResponse): PokemonUrlModel {
        var allAbilities = ""
        for (i in 0..<response.abilities.size){
            allAbilities += response.abilities[i].ability.name  + "\n"
        }
        return PokemonUrlModel(response.id, response.sprites.front_default, response.weight, response.height, allAbilities)
    }
}