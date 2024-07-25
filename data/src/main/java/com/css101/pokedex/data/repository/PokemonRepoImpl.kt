package com.css101.pokedex.data.repository

import com.css101.pokedex.data.models.PokemonListStorage
import com.css101.pokedex.data.storage.retrofit.PokedexApi
import com.css101.pokedex.domain.models.Pokemon
import com.css101.pokedex.domain.models.PokemonDetails
import com.css101.pokedex.domain.models.PokemonList
import com.css101.pokedex.domain.repository.PokemonRepo

class PokemonRepoImpl(private val api: PokedexApi) : PokemonRepo {
    override suspend fun getPokemonList(url: String?): PokemonList? {
        val list = url?.let { api.getPokemonList(url).body() } ?: api.getPokemonList().body()
        return storageToDomain(list)
    }

    override suspend fun getPokemon(url: String): PokemonDetails? {
        return api.getPokemonDetails(url).body()
    }

    private fun storageToDomain(storage: PokemonListStorage?): PokemonList? {
        return storage?.let { storage1 ->
            PokemonList(
                count = storage1.count,
                next = storage1.next,
                previous = storage1.previous,
                results = storage1.results.map {
                    Pokemon(name = it.name, url = it.url)
                })
        }
    }
}
