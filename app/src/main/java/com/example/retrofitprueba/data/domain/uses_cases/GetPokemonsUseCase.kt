package com.example.retrofitprueba.data.domain.uses_cases

import com.example.retrofitprueba.commons.GET_LIST_POKEMON_LIMIT
import com.example.retrofitprueba.commons.GET_LIST_POKEMON_OFFSET
import com.example.retrofitprueba.data.PokemonsRepository
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.GetListPokemonResultMapper
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonsRepository,
                                             private val getListPokemonResultMapper: GetListPokemonResultMapper){
    suspend operator fun invoke() : List<PokemonModel> = getListPokemonResultMapper.fromResponse(repository.getPokemons(
        GET_LIST_POKEMON_LIMIT, GET_LIST_POKEMON_OFFSET)).results
}