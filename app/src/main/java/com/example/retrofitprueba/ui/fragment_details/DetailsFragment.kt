package com.example.retrofitprueba.ui.fragment_details

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.retrofitprueba.R
import com.example.retrofitprueba.commons.POKEMON_DETAILS_KEY
import com.example.retrofitprueba.commons.POKEMON_NAME_KEY
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private val viewModel by viewModels<DetailsFragmentViewModel>()
    private lateinit var binding : FragmentDetailsBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pokemonName = arguments?.getString(POKEMON_NAME_KEY)
        val pokemonUrlModel = arguments?.getParcelable<PokemonUrlModel>(POKEMON_DETAILS_KEY)
        // Forma alternativa para getParcelable, utilizar la anterior aunque este deprecada, de momento
        /* val pokemonUrlModel = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("pokemon", PokemonUrlModel::class.java)
        }*/

        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.txtPokemonNameFragment.text = pokemonName?.replaceFirstChar { it.uppercaseChar() }
        println("Nombre de pokemon: $pokemonName")

        val weightHg = pokemonUrlModel?.weight
        binding.txtPokemonWeightFragment.text =   "$weightHg Hg   ${viewModel.convertHectogramsToKg(weightHg?.toDouble()!!)} Kg\n${viewModel.convertHectogramsToPounds(weightHg.toDouble())} Pounds   ${viewModel.convertHectogramsToOunces(weightHg.toDouble())} Ounces"

        val heightDm = pokemonUrlModel.height
        binding.txtPokemonHeightFragment.text = "$heightDm Dm   ${viewModel.convertDecimetersToMeters(heightDm.toDouble())} m   ${viewModel.convertDecimetersTofeet(heightDm.toDouble())} Feet"

        binding.txtPokemonAbilitiesFragment.text = pokemonUrlModel.abilities

        val image = Uri.parse(pokemonUrlModel.sprites)
        Picasso.get()
            .load(image)
            .error(R.drawable.ic_launcher_background)
            .into(binding.imgPokemonFragment)

        binding.btnBack.setOnClickListener {
            activity?.findViewById<View>(R.id.viewBlockActivity)?.visibility = View.GONE
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        return binding.root
    }

    override fun onStop() {
        super.onStop()
        activity?.findViewById<View>(R.id.viewBlockActivity)?.visibility = View.GONE
    }
}