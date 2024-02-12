package com.example.retrofitprueba.data.domain.repository.remote.mapper

import com.example.retrofitprueba.data.domain.model.PokemonModel
import com.example.retrofitprueba.data.domain.model.ResultModel
import com.example.retrofitprueba.data.domain.repository.remote.response.PokemonResponse
import javax.inject.Inject

class GetListPokemonResultMapper @Inject constructor():
    ResponseMapper<List<PokemonResponse>, ResultModel> {
    override fun fromResponse(listPokemonResponse: List<PokemonResponse>): ResultModel {

        val resultModel = mutableListOf<PokemonModel>()

        if (!listPokemonResponse.isNullOrEmpty()) {
            val pokemonMapper = PokemonMapper()
            listPokemonResponse.forEach { getListPokemonResultResponse ->
                resultModel.add(pokemonMapper.fromResponse(getListPokemonResultResponse))
            }
        }

        return ResultModel(
            resultModel
        )
    }
}