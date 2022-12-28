package com.canivek.pokecompose.pokeapi

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonsResponse(
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult> = emptyList(),
)

@JsonClass(generateAdapter = true)
data class PokemonResult(
    val name: String,
    val url: String,
)
