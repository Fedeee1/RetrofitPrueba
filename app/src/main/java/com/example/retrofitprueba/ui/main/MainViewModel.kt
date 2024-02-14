package com.example.retrofitprueba.ui.main

import androidx.lifecycle.ViewModel
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonDetailsUseCase
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonsDetailsListUseCase
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPokemonsUseCase: GetPokemonsListUseCase,
                                        private val getPokemonsDetailsUseCase: GetPokemonDetailsUseCase,
                                        private val getPokemonsDetailsListUseCase: GetPokemonsDetailsListUseCase): ViewModel() {

    private var listPokemons: List<PokemonModel> = listOf()
    var listPokemonsFlow: Flow<List<PokemonModel>> = flow {
        isLoading = true
        listPokemons = getPokemonsUseCase()
        emit(listPokemons)
    }

    private var pokemonsDetails = PokemonUrlModel("", "", "","","")
    var pokemonDetailsFlow: Flow<PokemonUrlModel> = flow {
        isLoading = true
        pokemonsDetails = getPokemonsDetailsUseCase("bulbasaur")
        emit(pokemonsDetails)
    }

    private var listPokemonsDetails = listOf<PokemonUrlModel>()
    var listPokemonsDetailsFlow: Flow<List<PokemonUrlModel>> = flow {
        isLoading = true
        listPokemonsDetails = getPokemonsDetailsListUseCase()
        emit(listPokemonsDetails)
    }

    private var isLoading: Boolean = true
    var isLoadingFlow: Flow<Boolean> = flow {
        emit(isLoading)
    }
}