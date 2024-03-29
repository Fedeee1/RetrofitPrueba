package com.example.retrofitprueba.ui.main.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitprueba.R
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel
import com.example.retrofitprueba.data.domain.model.pokemon.pokemon_details.PokemonUrlModel
import com.example.retrofitprueba.ui.main.MainActivity
import com.squareup.picasso.Picasso
import javax.inject.Inject

class RecyclerPokemonsAdapter @Inject constructor(
    private var listPokemons: List<PokemonModel>,
    private var listPokemonsDetails: List<PokemonUrlModel>,
    private var activity: MainActivity,
    private val listener: OnPokemonItemClickListener):
    RecyclerView.Adapter<RecyclerPokemonsAdapter.ViewHolder>() {

    interface OnPokemonItemClickListener{
        fun onPokemonClick(pokemonUrl: PokemonUrlModel, pokemon: PokemonModel)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtPokemonName: TextView
        var imgPokemon: ImageView
        private var constraintCardPokemons: ConstraintLayout
        var cardPokemon: CardView
        var viewBlockActivity: View

        init {
            txtPokemonName = itemView.findViewById(R.id.txtPokemonName)
            imgPokemon = itemView.findViewById(R.id.imgPokemon)
            constraintCardPokemons = itemView.findViewById(R.id.constraintCardPokemons)
            cardPokemon = itemView.findViewById(R.id.cardPokemon)
            viewBlockActivity = activity.findViewById(R.id.viewBlockActivity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pokemons, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.txtPokemonName.text = listPokemons[position].name.replaceFirstChar { it.uppercaseChar() }

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