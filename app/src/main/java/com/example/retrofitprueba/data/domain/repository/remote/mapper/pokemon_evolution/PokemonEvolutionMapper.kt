package com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemon_evolution

import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_evolutions.PokemonEvolutionModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_evolutions_response.PokemonEvolutionResponse

class PokemonEvolutionMapper : ResponseMapper<PokemonEvolutionResponse, PokemonEvolutionModel> {
    override fun fromResponse(response: PokemonEvolutionResponse): PokemonEvolutionModel {
        return PokemonEvolutionModel(response.chain.evolves_to.evolves_to.species.name)
    }
}