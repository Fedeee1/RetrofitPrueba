package com.example.retrofitprueba.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitprueba.R
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonUrlModel
import com.example.retrofitprueba.databinding.ActivityMainBinding
import com.example.retrofitprueba.ui.fragment_details.DetailsFragment
import com.example.retrofitprueba.ui.main.adapter.RecyclerPokemonsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RecyclerPokemonsAdapter.onPokemonItemClickListener {

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
            var listPokemonsDetails = listOf<PokemonUrlModel>()
            var listPokemons = listOf<PokemonModel>()
            viewModel.listPokemonsDetailsFlow.collect {
                listPokemonsDetails = it
                println(it)
            }
            viewModel.listPokemonsFlow.collect {
                listPokemons = it
                println("lista $it")
                binding.progressLoading.isVisible = false
            }
            println(listPokemonsDetails)
            addRecyclerView(listPokemons, listPokemonsDetails)
        }
        viewModel.viewModelScope.launch {
            viewModel.isLoadingFlow.collect {
                binding.progressLoading.isVisible = it
            }
        }

    }

    private fun addRecyclerView(listPokemons: List<PokemonModel>, listPokemonsDetails: List<PokemonUrlModel>) {
        val adapter = RecyclerPokemonsAdapter(listPokemons, listPokemonsDetails, this, this)
        binding.recyclerPokemons.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerPokemons.adapter = adapter
    }

    override fun onPokemonClick(pokemonUrl: PokemonUrlModel, pokemon: PokemonModel) {
        openFragment(pokemonUrl , pokemon.name)
    }

    private fun openFragment(pokemonUrlModel: PokemonUrlModel, pokemonsName: String){
        val bundle = Bundle()
        bundle.putParcelable("pokemon", pokemonUrlModel)
        bundle.putString("pokemonName", pokemonsName)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val fragment = DetailsFragment()
        fragment.arguments = bundle
        transaction.replace(R.id.fragmentDetails, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}