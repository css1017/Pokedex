package com.css101.pokedex.di

import com.css101.pokedex.domain.usecase.GetPokemonDetailsUseCase
import com.css101.pokedex.domain.usecase.GetPokemonListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetPokemonListUseCase(get()) }
    factory { GetPokemonDetailsUseCase(get()) }
}