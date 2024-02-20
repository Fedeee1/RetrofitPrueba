package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_details_response.PokemonSpritesResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.pokemon_details_response.PokemonUrlResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonProvider @Inject constructor() {
        var pokemons: List<PokemonResponse> = emptyList()
        var pokemonsDetails: PokemonUrlResponse = PokemonUrlResponse("", PokemonSpritesResponse("","",""),"","", emptyList(), "")

}