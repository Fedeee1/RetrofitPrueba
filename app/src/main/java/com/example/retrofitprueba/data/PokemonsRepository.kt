package com.example.retrofitprueba.data

import com.example.retrofitprueba.data.domain.model.pokemon.ResultModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.PokemonService
import com.example.retrofitprueba.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonsRepository @Inject constructor(private val api: PokemonService) {

    fun getListPokemon(limit: Int, offset: Int): Flow<BaseResponse<ResultModel>> {
        return api.getListPokemon(limit, offset)
    }

    fun getPokemonDetailsError(name: String): Flow<BaseResponse<PokemonUrlModel>> {
        return api.getPokemonsDetailsError(name)
    }


}

