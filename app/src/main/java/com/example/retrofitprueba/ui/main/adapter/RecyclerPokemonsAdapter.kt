package com.example.retrofitprueba.ui.main.adapter

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitprueba.R
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonUrlModel
import com.example.retrofitprueba.ui.fragment_details.DetailsFragment
import com.example.retrofitprueba.ui.main.MainActivity
import com.squareup.picasso.Picasso

class RecyclerPokemonsAdapter(listPokemon: List<PokemonModel>, listPokemonsDetails: List<PokemonUrlModel>, activity: MainActivity,
    private val listener: onPokemonItemClickListener):
    RecyclerView.Adapter<RecyclerPokemonsAdapter.ViewHolder>() {

    interface onPokemonItemClickListener{
        fun onPokemonClick(pokemonUrl: PokemonUrlModel ,pokemon: PokemonModel)
    }

    private var listPokemons = listPokemon
    private var listPokemonsDetails = listPokemonsDetails
    private var activity = activity
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtCountryName: TextView
        var imgPokemon: ImageView
        var linearCardPokemons: LinearLayout
        var cardPokemon: CardView
        var viewBlockActivity: View

        init {
            txtCountryName = itemView.findViewById(R.id.txtPokemonName)
            imgPokemon = itemView.findViewById(R.id.imgPokemon)
            linearCardPokemons = itemView.findViewById(R.id.linearCardPokemons)
            cardPokemon = itemView.findViewById(R.id.cardPokemon)
            viewBlockActivity = activity.findViewById(R.id.viewBlockActivity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pokemons, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.txtCountryName.text = listPokemons[position].name.capitalize()

        val image = Uri.parse(listPokemonsDetails[position].sprites)
        Picasso.get()
            .load(image)
            .error(R.drawable.ic_launcher_background)
            .into(viewHolder.imgPokemon)

        viewHolder.cardPokemon.setOnClickListener {
            val pokemon = listPokemons[position]
            val pokemonUrl = listPokemonsDetails[position]
            listener.onPokemonClick(pokemonUrl ,pokemon)
            viewHolder.viewBlockActivity.visibility = View.VISIBLE
        }
    }
    override fun getItemCount(): Int {
        return listPokemons.size
    }
}