package com.example.retrofitprueba.ui.main

import androidx.lifecycle.ViewModel
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPokemonsUseCase: GetPokemonsUseCase): ViewModel() {

    private var listPokemons: List<PokemonModel> = listOf()
    var listPokemonsFlow: Flow<List<PokemonModel>> = flow {
        isLoading = true
        listPokemons = getPokemonsUseCase()
        emit(listPokemons)
    }

    private var isLoading: Boolean = true
    var isLoadingFlow: Flow<Boolean> = flow {
        emit(isLoading)
    }
}