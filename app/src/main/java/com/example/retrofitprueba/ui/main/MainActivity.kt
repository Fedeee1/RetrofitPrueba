package com.example.retrofitprueba.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
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
        setupViewModel()

    }

    private fun setupViewModel(){
        viewModel.viewModelScope.launch {
            var listPokemonsDetails = listOf<PokemonUrlModel>()
            var listPokemons = listOf<PokemonModel>()
            viewModel.listPokemonsFlow.collect {
                listPokemons = it
                println("lista $it")
            }
            viewModel.listPokemonsDetailsFlow.collect {
                listPokemonsDetails = it
                println(it)
            }
            addRecyclerView(listPokemons, listPokemonsDetails)
            binding.progressLoading.isVisible = false
        }
    }

    private fun addRecyclerView(listPokemons: List<PokemonModel>, listPokemonsDetails: List<PokemonUrlModel>) {
        val adapter = RecyclerPokemonsAdapter(listPokemons, listPokemonsDetails,this, this)
        binding.recyclerPokemons.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerPokemons.adapter = adapter
    }

    override fun onPokemonClick(pokemonUrl: PokemonUrlModel, pokemon: PokemonModel) {
        viewModel.name = pokemon.name
        println("Pokemon id: " + pokemonUrl.id)
        openFragment(pokemonUrl , pokemon.name)
    }

    private fun openFragment(pokemonUrlModel: PokemonUrlModel, pokemonsName: String){
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