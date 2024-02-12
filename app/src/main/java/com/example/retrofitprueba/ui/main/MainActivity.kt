package com.example.retrofitprueba.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitprueba.R
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.databinding.ActivityMainBinding
import com.example.retrofitprueba.ui.main.adapter.RecyclerPokemonsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
    }

    private fun setupViewModel(){
        viewModel.viewModelScope.launch {
            viewModel.listPokemonsFlow.collect {
                addRecyclerView(it)
                binding.progressLoading.isVisible = false
            }
        }
        viewModel.viewModelScope.launch {
            viewModel.isLoadingFlow.collect {
                binding.progressLoading.isVisible = it
            }
        }
    }

    private fun addRecyclerView(listPokemons: List<PokemonModel>) {
        val adapter = RecyclerPokemonsAdapter(listPokemons)
        binding.recyclerPokemons.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerPokemons.adapter = adapter
    }
}