package com.css101.pokedex.data.storage.retrofit

import com.css101.pokedex.data.models.PokemonListStorage
import com.css101.pokedex.domain.models.PokemonDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokedexApi {
    @GET("pokemon")
    suspend fun getPokemonList(): Response<PokemonListStorage>

    @GET
    suspend fun getPokemonDetails(@Url url: String): Response<PokemonDetails>
}