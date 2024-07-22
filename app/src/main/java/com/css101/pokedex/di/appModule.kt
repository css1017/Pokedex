package com.css101.pokedex.di

import com.css101.pokedex.ui.favourites.FavouritePokemonPresenter
import com.css101.pokedex.ui.pokedex.PokedexPresenter
import com.css101.pokedex.ui.random.RandomPokemonPresenter
import org.koin.dsl.module

val appModule = module {
    single { PokedexPresenter() }
    single { RandomPokemonPresenter() }
    single { FavouritePokemonPresenter() }
}