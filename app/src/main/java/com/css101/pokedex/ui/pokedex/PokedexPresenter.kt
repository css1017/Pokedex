package com.css101.pokedex.ui.pokedex

import com.css101.pokedex.domain.models.PokemonDetails
import com.css101.pokedex.domain.usecase.GetPokemonDetailsUseCase
import com.css101.pokedex.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope

@InjectViewState
class PokedexPresenter(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : MvpPresenter<PokedexView>() {

    private var isDataLoaded = false
    private var isDataLoading = false

    fun showPokedex() {
        if (!isDataLoaded && !isDataLoading) {
            presenterScope.launch(Dispatchers.IO) {
                isDataLoading = true

                val listLinks = try {
                    getPokemonListUseCase.execute()
                } catch (e: Exception) {
                    null
                }

                val list = mutableListOf<PokemonDetails?>()
                if (listLinks?.results != null) {
                    val deferredResults = listLinks.results.map { result ->
                        async {
                            try {
                                getPokemonDetailsUseCase.execute(result.url)
                            } catch (e: Exception) {
                                null
                            }
                        }
                    }

                    val pokemonDetailsList = deferredResults.awaitAll()
                    list.addAll(pokemonDetailsList)
                }

                withContext(Dispatchers.Main) {
                    viewState.showPokedex(list)
                }

                isDataLoading = false
                isDataLoaded = true
            }
        }
    }
}