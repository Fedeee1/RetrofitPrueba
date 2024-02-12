package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.repository.remote.response.ResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiClient {
    @GET("pokemon")
    suspend fun getListPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): Response<ResultResponse>
}