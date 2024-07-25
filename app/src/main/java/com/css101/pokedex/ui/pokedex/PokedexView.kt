package com.css101.pokedex.ui.pokedex

import com.css101.pokedex.domain.models.PokemonDetails
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PokedexView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showPokedex(pokemons: List<PokemonDetails?>)
}