package com.example.retrofitprueba.data.domain.uses_cases

import com.example.retrofitprueba.data.PokemonsRepository
import com.example.retrofitprueba.data.domain.model.pokemon.ResultModel
import com.example.retrofitprueba.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsListUseCase @Inject constructor(private val repository: PokemonsRepository){
    operator fun invoke(limit: Int, offset: Int): Flow<BaseResponse<ResultModel>> {
        return repository.getListPokemon(limit, offset)
    }
}