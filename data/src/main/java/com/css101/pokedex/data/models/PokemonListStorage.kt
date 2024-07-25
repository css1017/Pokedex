package com.css101.pokedex.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonListStorage(
    @JsonProperty("count") val count: Int,
    @JsonProperty("next") val next: String?,
    @JsonProperty("previous") val previous: String?,
    @JsonProperty("results") val results: List<PokemonStorage>
)

data class PokemonStorage(
    @JsonProperty("name") val name: String,
    @JsonProperty("url") val url: String
)
