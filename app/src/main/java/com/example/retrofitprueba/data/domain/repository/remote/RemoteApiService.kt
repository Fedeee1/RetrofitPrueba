package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.ResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteApiService {
    @GET("pokemon")
    suspend fun getListPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResultResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name : String
    ): Response<PokemonUrlResponse>

    @GET("evolution-chain/{id}")
    suspend fun getPokemonEvolutions(
        @Path("id") id : String
    ): Response<PokemonUrlResponse>

}