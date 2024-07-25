package com.css101.pokedex.domain.usecase

import com.css101.pokedex.domain.models.PokemonList
import com.css101.pokedex.domain.repository.PokemonRepo

class GetPokemonListUseCase(private val repo: PokemonRepo) {

    suspend fun execute(url: String?):PokemonList? {
        return repo.getPokemonList(url)
    }
}