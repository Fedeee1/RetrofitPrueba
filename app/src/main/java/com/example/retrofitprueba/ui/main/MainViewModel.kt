package com.example.retrofitprueba.ui.main

import androidx.lifecycle.ViewModel
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonsDetailsListUseCase
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPokemonsUseCase: GetPokemonsListUseCase,
                                        private val getPokemonsDetailsListUseCase: GetPokemonsDetailsListUseCase): ViewModel() {

    var name = ""

    private var listPokemons: List<PokemonModel> = listOf()
    var listPokemonsFlow: Flow<List<PokemonModel>> = flow {
        listPokemons = getPokemonsUseCase()
        emit(listPokemons)
    }

    private var listPokemonsDetails = listOf<PokemonUrlModel>()
    var listPokemonsDetailsFlow: Flow<List<PokemonUrlModel>> = flow {
        listPokemonsDetails = getPokemonsDetailsListUseCase()
        emit(listPokemonsDetails)
    }
}