package com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemon_evolution

import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_evolutions.PokemonEvolutionModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_evolutions_response.PokemonEvolutionResponse
import javax.inject.Inject

class GetPokemonEvolutionMapper @Inject constructor():
    ResponseMapper<PokemonEvolutionResponse, PokemonEvolutionModel> {
    override fun fromResponse(pokemonResponse: PokemonEvolutionResponse): PokemonEvolutionModel {
        var resultModel = PokemonEvolutionModel("")

        if (pokemonResponse != null) {
            val pokemonEvolutionMapper = PokemonEvolutionMapper()
            resultModel = pokemonEvolutionMapper.fromResponse(pokemonResponse)
        }
        return resultModel
    }
}
