package com.css101.pokedex.ui.pokedex

import com.css101.pokedex.domain.models.PokemonDetails
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PokedexView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showPokedex(pokemons: List<PokemonDetails?>)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setBackBtn(previous: String?)
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setForwardBtn(forward: String?)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showLoading()
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError()
}