package com.example.retrofitprueba.ui.main.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitprueba.R
import com.example.retrofitprueba.data.domain.model.pokemon.PokemonModel

class RecyclerPokemonsAdapter(listPokemon: List<PokemonModel>): RecyclerView.Adapter<RecyclerPokemonsAdapter.ViewHolder>() {

    private var listPokemons = listPokemon

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtCountryName: TextView
        var imgPokemon: ImageView
        var cardPokemon: CardView

        init {
            txtCountryName = itemView.findViewById(R.id.txtPokemonName)
            imgPokemon = itemView.findViewById(R.id.imgPokemon)
            cardPokemon = itemView.findViewById(R.id.cardPokemon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pokemons, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.txtCountryName.text = listPokemons[position].name

//        val image = Uri.parse(listPokemons[position].href.toString())
//        Picasso.get()
//            .load(image)
//            .error(R.drawable.image_map)
//            .into(viewHolder.imgPokemon)
    }

    override fun getItemCount(): Int {
        return listPokemons.size
    }
}