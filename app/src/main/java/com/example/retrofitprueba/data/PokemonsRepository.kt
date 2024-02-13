package com.example.retrofitprueba.data

import com.example.retrofitprueba.data.domain.repository.remote.PokemonProvider
import com.example.retrofitprueba.data.domain.repository.remote.PokemonService
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse
import javax.inject.Inject


class PokemonsRepository @Inject constructor(private val api: PokemonService, private val pokemonProvider: PokemonProvider) {

    suspend fun getPokemons(limit: Int, offset: Int) : List<PokemonResponse>{
        val response = api.getPokemons(limit, offset)
        pokemonProvider.pokemons = response
        return response
    }

    suspend fun getPokemonsDetails(name: String) : PokemonUrlResponse{
        val response = api.getPokemonsDetails(name)
        pokemonProvider.pokemonsDetails = response
        return response
    }

}

