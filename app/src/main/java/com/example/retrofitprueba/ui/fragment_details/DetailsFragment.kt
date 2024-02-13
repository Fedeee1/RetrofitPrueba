package com.example.retrofitprueba.ui.fragment_details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.retrofitprueba.R
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonUrlModel
import com.example.retrofitprueba.ui.main.MainActivity
import com.example.retrofitprueba.ui.main.MainViewModel
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private lateinit var txtPokemonName: TextView
    private lateinit var txtPokemonWeight: TextView
    private lateinit var txtPokemonHeight: TextView
    private lateinit var txtPokemonAbilities: TextView
    private lateinit var imgPokemon: ImageView
    private lateinit var btnBack: Button

    private val viewModel by viewModels<DetailsFragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pokemonName = arguments?.getString("pokemonName")
        val pokemonUrlModel = arguments?.getParcelable<PokemonUrlModel>("pokemon")

        var view: View = inflater.inflate(R.layout.fragment_details, container, false)

        txtPokemonName = view.findViewById(R.id.txtPokemonNameFragment)
        txtPokemonName.text = pokemonName?.capitalize()
        println("Nombre de pokemon: $pokemonName")

        val weightHg = pokemonUrlModel?.weight
        txtPokemonWeight = view.findViewById(R.id.txtPokemonWeightFragment)
        txtPokemonWeight.text =
            weightHg + " Hg   " + viewModel.convertHectogramsToKg(weightHg?.toDouble()!!) + " Kg\n" + viewModel.convertHectogramsToPounds(
                weightHg?.toDouble()!!
            ) + " Pounds   " + viewModel.convertHectogramsToOunces(weightHg?.toDouble()!!) + " Ounces"

        val heightDm = pokemonUrlModel?.height
        txtPokemonHeight = view.findViewById(R.id.txtPokemonHeightFragment)
        txtPokemonHeight.text = heightDm + " Dm   " +  viewModel.convertDecimetersToMeters(heightDm?.toDouble()!!) + " m   " +  viewModel.convertDecimetersTofeet(heightDm?.toDouble()!!) + " feet"

        txtPokemonAbilities = view.findViewById(R.id.txtPokemonAbilitiesFragment)
        txtPokemonAbilities.text = pokemonUrlModel?.abilities.toString()

        imgPokemon = view.findViewById(R.id.imgPokemonFragment)
        val image = Uri.parse(pokemonUrlModel?.sprites.toString())
        Picasso.get()
            .load(image)
            .error(R.drawable.ic_launcher_background)
            .into(imgPokemon)

        btnBack = view.findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            activity?.findViewById<View>(R.id.viewBlockActivity)?.visibility = View.GONE
            activity?.onBackPressed()
        }
        return view
    }
}