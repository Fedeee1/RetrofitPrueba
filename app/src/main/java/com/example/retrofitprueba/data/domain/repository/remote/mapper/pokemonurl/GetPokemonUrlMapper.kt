package com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemonurl

import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_details_response.PokemonUrlResponse
import javax.inject.Inject

class GetPokemonUrlMapper @Inject constructor():
    ResponseMapper<PokemonUrlResponse, PokemonUrlModel> {
    override fun fromResponse(pokemonResponse: PokemonUrlResponse): PokemonUrlModel {
        var resultModel = PokemonUrlModel("", "", "", "", "")

        if (pokemonResponse != null) {
            val pokemonUrlMapper = PokemonUrlMapper()
            resultModel = pokemonUrlMapper.fromResponse(pokemonResponse)
        }
        return resultModel
    }
}
