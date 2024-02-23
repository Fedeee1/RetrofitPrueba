package com.example.retrofitprueba.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitprueba.R
import com.example.retrofitprueba.commons.POKEMON_DETAILS_KEY
import com.example.retrofitprueba.commons.POKEMON_NAME_KEY
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.databinding.ActivityMainBinding
import com.example.retrofitprueba.ui.fragment_details.DetailsFragment
import com.example.retrofitprueba.ui.main.adapter.RecyclerPokemonsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RecyclerPokemonsAdapter.OnPokemonItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressLoading.isVisible = true
        setUpViewModel()
        viewModel.getListPokemon()
    }

    private fun setUpViewModel() {

        var listPokemonsDetails: List<PokemonUrlModel>
        var listPokemons = listOf<PokemonModel>()

        lifecycleScope.launch {
            viewModel.listPokemonNamesStateFlow.collect { dataSet ->
                listPokemons = dataSet
                viewModel.getPokemonDetails(listPokemons)
            }
        }
        lifecycleScope.launch {
            viewModel.listPokemonErrorSharedFlow.collect { error ->
                Toast.makeText(this@MainActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        }
        lifecycleScope.launch {
            viewModel.listPokemonDetailsStateFlow.collect { dataSet ->
                listPokemonsDetails = dataSet
                addRecyclerView(listPokemons, listPokemonsDetails)
            }
        }
        lifecycleScope.launch {
            viewModel.isProgressVisibleFlow.collect {
                binding.progressLoading.isVisible = it
            }
        }
    }

    private fun addRecyclerView(
        listPokemons: List<PokemonModel>,
        listPokemonsDetails: List<PokemonUrlModel>
    ) {
        val adapter = RecyclerPokemonsAdapter(listPokemons, listPokemonsDetails, this, this)
        binding.recyclerPokemons.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerPokemons.adapter = adapter
    }

    override fun onPokemonClick(pokemonUrl: PokemonUrlModel, pokemon: PokemonModel) {
        println("Pokemon id: " + pokemonUrl.id)
        openFragment(pokemonUrl, pokemon.name)
    }

    private fun openFragment(pokemonUrlModel: PokemonUrlModel, pokemonsName: String) {
        val bundle = Bundle()
        viewModel.viewModelScope.launch {
            bundle.putParcelable(POKEMON_DETAILS_KEY, pokemonUrlModel)
            bundle.putString(POKEMON_NAME_KEY, pokemonsName)
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            transaction.replace(R.id.fragmentDetails, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}