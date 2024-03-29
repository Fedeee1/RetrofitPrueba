package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.ResultResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_details_response.PokemonUrlResponse
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
}