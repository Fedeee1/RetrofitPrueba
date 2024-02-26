package com.example.retrofitprueba.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitprueba.commons.GET_LIST_POKEMON_LIMIT
import com.example.retrofitprueba.commons.GET_LIST_POKEMON_OFFSET
import com.example.retrofitprueba.data.domain.model.error.ErrorModel
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonDetailsUseCase
import com.example.retrofitprueba.data.domain.uses_cases.GetPokemonsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPokemonsListErrorCheckedUseCase: GetPokemonsListUseCase,
    private val getPokemonDetailsErrorUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

    private val listPokemonNamesMutableStateFlow =
        MutableStateFlow<ArrayList<PokemonModel>>(arrayListOf())
    val listPokemonNamesStateFlow: StateFlow<ArrayList<PokemonModel>> =
        listPokemonNamesMutableStateFlow

    private val listPokemonErrorMutableSharedFlow = MutableSharedFlow<ErrorModel>()
    val listPokemonErrorSharedFlow: SharedFlow<ErrorModel> = listPokemonErrorMutableSharedFlow
    fun getListPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            getPokemonsListErrorCheckedUseCase(
                GET_LIST_POKEMON_LIMIT,
                GET_LIST_POKEMON_OFFSET
            ).collect {
                when (it) {
                    is BaseResponse.Error -> {
                        listPokemonErrorMutableSharedFlow.emit(it.error)
                    }
                    is BaseResponse.Success -> {
                        val arrayList = ArrayList(it.data.results)
                        listPokemonNamesMutableStateFlow.value = arrayList
                    }
                }
            }
        }
    }

    private val listPokemonDetailsMutableStateFlow =
        MutableStateFlow<MutableList<PokemonUrlModel>>(mutableListOf())
    val listPokemonDetailsStateFlow: StateFlow<MutableList<PokemonUrlModel>> =
        listPokemonDetailsMutableStateFlow

    private val pokemonDetailsErrorMutableSharedFlow = MutableSharedFlow<ErrorModel>()
    val pokemonDetailsErrorSharedFlow: SharedFlow<ErrorModel> = pokemonDetailsErrorMutableSharedFlow

    private val isProgressVisible = MutableStateFlow(true)
    var isProgressVisibleFlow: Flow<Boolean> = isProgressVisible

    fun getPokemonDetails(listPokemonsNames: List<PokemonModel>) {
        val listPokemonsDetails = mutableListOf<PokemonUrlModel>()

        viewModelScope.launch(Dispatchers.IO) {
            var error = false
            for (i in listPokemonsNames) {
                getPokemonDetailsErrorUseCase(i.name).collect {
                    when (it) {
                        is BaseResponse.Error -> {
                            pokemonDetailsErrorMutableSharedFlow.emit(it.error)
                            error = true
                        }
                        is BaseResponse.Success -> {
                            listPokemonsDetails.add(it.data)
                        }
                    }
                }
                if (listPokemonsNames.last().name == i.name) {
                    isProgressVisible.value = false
                }
                if (error){
                    break
                }
            }
            listPokemonDetailsMutableStateFlow.emit(listPokemonsDetails)
        }
    }
}