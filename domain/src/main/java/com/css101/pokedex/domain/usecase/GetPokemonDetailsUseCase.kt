package com.css101.pokedex.domain.usecase

import com.css101.pokedex.domain.models.PokemonDetails
import com.css101.pokedex.domain.repository.PokemonRepo

class GetPokemonDetailsUseCase(private val repo: PokemonRepo) {
    suspend fun execute(url: String): PokemonDetails? {
        return repo.getPokemon(url)
    }
}