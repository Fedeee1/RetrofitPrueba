package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.repository.remote.response.BaseApiCallService
import com.example.retrofitprueba.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.ResultResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_details_response.PokemonUrlResponse
import com.example.retrofitprueba.di.InjectionSingleton.Companion.provideApiServices
import javax.inject.Inject
class ApiCallService @Inject constructor() : BaseApiCallService() {

    suspend fun getListPokemon(limit: Int, offset: Int): BaseResponse<ResultResponse> {
        return apiCall {
            provideApiServices().getListPokemon(limit, offset)
        }
    }

    suspend fun getPokemonDetails(name: String): BaseResponse<PokemonUrlResponse> {
        return apiCall {
            provideApiServices().getPokemonDetails(name)
        }
    }
}