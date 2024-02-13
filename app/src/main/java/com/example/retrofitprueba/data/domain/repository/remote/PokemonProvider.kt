package com.example.retrofitprueba.data.domain.repository.remote

import com.example.retrofitprueba.data.domain.model.pokemon.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonSpritesResponse
import com.example.retrofitprueba.data.domain.repository.remote.response.pokemon.PokemonUrlResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonProvider @Inject constructor() {
        var pokemons: List<PokemonResponse> = emptyList()
        var pokemonsDetails: PokemonUrlResponse = PokemonUrlResponse("",
                PokemonSpritesResponse(""),"","", emptyList())
}