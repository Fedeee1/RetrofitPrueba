package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.core.RetrofitService
import com.example.retrofitprueba.data.domain.model.PokemonModel
import com.example.retrofitprueba.data.domain.repository.remote.response.PokemonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonService @Inject constructor (){
    private val service = RetrofitService.makeRetrofitService()

    suspend fun getPokemons(limit: Int, offset: Int): List<PokemonResponse> {
        return withContext(Dispatchers.IO) {
            val response = service.create(PokemonApiClient::class.java).getListPokemon(limit, offset)
            response.body()?.results ?: emptyList()
        }
    }

}