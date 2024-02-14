package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.core.RetrofitClient
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonService @Inject constructor() {
    private val service = RetrofitClient.makeRetrofitService()

    suspend fun getPokemons(limit: Int, offset: Int): List<PokemonResponse> {
        return withContext(Dispatchers.IO) {
            val response =
                service.create(RemoteApiService::class.java).getListPokemon(limit, offset)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getPokemonsDetails(name: String): PokemonUrlResponse {
        return withContext(Dispatchers.IO) {
            val response =
                service.create(RemoteApiService::class.java).getPokemonDetails(name)
            response.body()!!
        }
    }

    suspend fun getPokemonsEvolutions(id: String): PokemonUrlResponse {
        return withContext(Dispatchers.IO) {
            val response =
                service.create(RemoteApiService::class.java).getPokemonEvolutions(id)
            response.body()!!
        }
    }
}