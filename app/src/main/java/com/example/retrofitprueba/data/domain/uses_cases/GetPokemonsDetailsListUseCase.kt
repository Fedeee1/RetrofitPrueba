package com.example.retrofitprueba.data.domain.uses_cases

import com.example.retrofitprueba.data.PokemonsRepository
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemonurl.GetPokemonUrlMapper
import javax.inject.Inject

class GetPokemonsDetailsListUseCase @Inject constructor(
    private val repository: PokemonsRepository,
    private val getListPokemonUrlMapper: GetPokemonUrlMapper,
    private val getPokemonsListUseCase: GetPokemonsListUseCase
) {
    suspend operator fun invoke(): List<PokemonUrlModel> {
        var listPokemonsDetails = mutableListOf<PokemonUrlModel>()
        for (i in getPokemonsListUseCase()) {
            listPokemonsDetails.add(
                getListPokemonUrlMapper.fromResponse(
                    repository.getPokemonsDetails(
                        i.name
                    )
                )
            )
        }
        return listPokemonsDetails
    }


}