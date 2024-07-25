package com.css101.pokedex.di

import com.css101.pokedex.data.repository.PokemonRepoImpl
import com.css101.pokedex.domain.repository.PokemonRepo
import org.koin.dsl.module

val dataModule = module {
    single<PokemonRepo> { PokemonRepoImpl(get()) }
}