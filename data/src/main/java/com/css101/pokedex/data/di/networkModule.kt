package com.css101.pokedex.data.di

import com.css101.pokedex.data.storage.retrofit.PokedexApi
import com.css101.pokedex.data.storage.retrofit.RetrofitProvider
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { RetrofitProvider() }
    single { get<RetrofitProvider>().createRetrofit("https://pokeapi.co/api/v2/") }
    single { get<Retrofit>().create(PokedexApi::class.java) }
}