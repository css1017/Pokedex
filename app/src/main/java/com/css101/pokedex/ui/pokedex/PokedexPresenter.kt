package com.css101.pokedex.ui.pokedex

import com.css101.pokedex.domain.models.PokemonDetails
import com.css101.pokedex.domain.models.PokemonList
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

    private var pageData: PokemonList? = null
    private var isDataLoading = false

    fun showPokedex(url: String? = null) {
        if (pageData == null && !isDataLoading) {
            viewState.showLoading()
            presenterScope.launch(Dispatchers.IO) {
                isDataLoading = true
                pageData = try {
                    getPokemonListUseCase.execute(url)
                } catch (e: Exception) {
                    viewState.showError()
                    null
                }
                setButtons(pageData)
                val list = loadImages(pageData)

                withContext(Dispatchers.Main) {
                    viewState.showPokedex(list)
                    isDataLoading = false
                }
            }
        }
    }
fun loadNewPage(url: String? = null){
    pageData = null
    showPokedex(url)
}
    private suspend fun loadImages(listLinks: PokemonList?): List<PokemonDetails?> =
        withContext(Dispatchers.IO) {
            val list = mutableListOf<PokemonDetails?>()
            if (listLinks?.results != null) {
                val deferredResults = listLinks.results.map { result ->
                    async {
                        try {
                            getPokemonDetailsUseCase.execute(result.url)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            null
                        }
                    }
                }

                val pokemonDetailsList = deferredResults.awaitAll()
                list.addAll(pokemonDetailsList)
            }
            list
        }

    private fun setButtons(listLinks: PokemonList?) {
        viewState.setBackBtn(listLinks?.previous)
        viewState.setForwardBtn(listLinks?.next)
    }
}