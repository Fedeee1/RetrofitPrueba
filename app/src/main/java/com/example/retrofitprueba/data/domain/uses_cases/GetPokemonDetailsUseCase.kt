package com.example.retrofitprueba.data.domain.uses_cases

import com.example.retrofitprueba.data.PokemonsRepository
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.mapper.pokemonurl.GetPokemonUrlMapper
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(
    private val repository: PokemonsRepository,
    private val getListPokemonUrlMapper: GetPokemonUrlMapper
) {
    suspend operator fun invoke(name: String): PokemonUrlModel =
        getListPokemonUrlMapper.fromResponse(repository.getPokemonDetails(name))

}