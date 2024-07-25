package com.css101.pokedex.domain.repository

import com.css101.pokedex.domain.models.PokemonDetails
import com.css101.pokedex.domain.models.PokemonList

interface PokemonRepo {
    suspend fun getPokemonList(): PokemonList?
    suspend fun getPokemon(url: String): PokemonDetails?

}