package com.example.retrofitprueba.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import com.example.retrofitprueba.R
import com.example.retrofitprueba.databinding.ActivityMainBinding
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
                addListView(it)
                binding.progressLoading.isVisible = false
            }
        }
        viewModel.viewModelScope.launch {
            viewModel.isLoadingFlow.collect {
                binding.progressLoading.isVisible = it
            }
        }
    }

    private fun addListView(listPokemonsNames: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listPokemonsNames)
        binding.listViewPokemons.adapter = adapter
    }
}