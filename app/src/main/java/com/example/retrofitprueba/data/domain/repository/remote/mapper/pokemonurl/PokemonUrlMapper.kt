package com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemonurl

import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse

class PokemonUrlMapper : ResponseMapper<PokemonUrlResponse, PokemonUrlModel> {



    override fun fromResponse(response: PokemonUrlResponse): PokemonUrlModel {
        var allAbilities = ""
        for (i in 0..  response.abilities.size-1){
            allAbilities += response.abilities[i].ability.name  + "\n"
        }
        return PokemonUrlModel(response.id, response.sprites.image, response.weight, response.height, allAbilities)
    }
}