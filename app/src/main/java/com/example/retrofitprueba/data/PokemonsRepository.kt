package com.example.retrofitprueba.data

import com.example.retrofitprueba.data.domain.repository.remote.PokemonProvider
import com.example.retrofitprueba.data.domain.repository.remote.PokemonService
import com.example.retrofitprueba.data.domain.repository.remote.response.PokemonResponse
import javax.inject.Inject


class PokemonsRepository @Inject constructor(private val api: PokemonService, private val pokemonProvider: PokemonProvider) {

    suspend fun getPokemons(limit: Int, offset: Int) : List<PokemonResponse>{
        val response = api.getPokemons(limit, offset)
        pokemonProvider.pokemons = response
        return response
    }

}

