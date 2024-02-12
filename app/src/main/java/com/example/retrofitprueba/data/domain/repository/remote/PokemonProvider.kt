package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonProvider @Inject constructor() {
        var pokemons: List<PokemonResponse> = emptyList()
}