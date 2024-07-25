package com.css101.pokedex.ui.pokedex

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.css101.pokedex.R
import com.css101.pokedex.databinding.ItemPokemonListBinding
import com.css101.pokedex.domain.models.PokemonDetails

class PokedexViewHolder(private val binding: ItemPokemonListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PokemonDetails): Unit = with(binding) {
        val ctx = tvNameItem.context
        tvNameItem.text = item.name
        Glide.with(ctx)
            .load(item.sprites.frontDefault)
            .placeholder(R.drawable.ic_no_image)
            .error(R.drawable.ic_no_image)
            .into(ivItem)
    }

}