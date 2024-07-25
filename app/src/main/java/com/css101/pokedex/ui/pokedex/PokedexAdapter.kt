package com.css101.pokedex.ui.pokedex

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.css101.pokedex.databinding.ItemPokemonListBinding
import com.css101.pokedex.domain.models.PokemonDetails


class PokedexAdapter(
    private val items: List<PokemonDetails?>,
    private var onItemClick: ((PokemonDetails) -> Unit),
) : RecyclerView.Adapter<PokedexViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonListBinding.inflate(inflater, parent, false)
        return PokedexViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {
        val pokemon = items[position]
        if (pokemon != null){
            holder.bind(pokemon)
            holder.itemView.setOnClickListener {
                onItemClick(pokemon)
            }
        } else { Log.e("aaa", "$items")}
    }
}