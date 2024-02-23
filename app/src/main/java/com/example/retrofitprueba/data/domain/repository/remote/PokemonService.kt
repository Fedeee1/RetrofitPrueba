package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.model.pokemon.ResultModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemon.GetListPokemonResultMapper
import com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemonurl.PokemonUrlMapper
import com.example.retrofitprueba.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonService @Inject constructor(private val apiCallService: ApiCallService) {

    fun getListPokemon(limit: Int, offset: Int): Flow<BaseResponse<ResultModel>> = flow {
        val apiResult = apiCallService.getListPokemon(limit, offset)
        if (apiResult is BaseResponse.Success) {
            emit(BaseResponse.Success(GetListPokemonResultMapper().fromResponse(apiResult.data.results)))
        } else if (apiResult is BaseResponse.Error) {
            emit(BaseResponse.Error(apiResult.error))
        }
    }

    fun getPokemonsDetailsError(name: String): Flow<BaseResponse<PokemonUrlModel>> = flow {
        val apiResult = apiCallService.getPokemonDetails(name)
        if (apiResult is BaseResponse.Success) {
            emit(BaseResponse.Success(PokemonUrlMapper().fromResponse(apiResult.data)))
        } else if (apiResult is BaseResponse.Error) {
            emit(BaseResponse.Error(apiResult.error))
        }
    }
}