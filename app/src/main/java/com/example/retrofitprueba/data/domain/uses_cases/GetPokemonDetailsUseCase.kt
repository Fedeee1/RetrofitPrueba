package com.example.retrofitprueba.data.domain.uses_cases

import com.example.retrofitprueba.data.PokemonsRepository
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor (private val repository: PokemonsRepository) {
    operator fun invoke(name: String): Flow<BaseResponse<PokemonUrlModel>> {
        return repository.getPokemonDetailsError(name)
    }
}