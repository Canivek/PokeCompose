package com.canivek.pokecompose.pokeapi

import retrofit2.http.GET

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemons(): PokemonsResponse
}
