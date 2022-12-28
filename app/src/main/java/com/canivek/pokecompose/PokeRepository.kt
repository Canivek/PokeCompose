package com.canivek.pokecompose

import com.canivek.pokecompose.pokeapi.PokeApi
import com.canivek.pokecompose.pokeapi.PokemonResult

class PokeRepository(private val pokeApi: PokeApi) {

    suspend fun getPokemons(): List<Pokemon> {
        val response = pokeApi.getPokemons()
        return response.results.map(PokemonResult::toPokemon)
    }
}

private fun PokemonResult.toPokemon(): Pokemon {
    return Pokemon(
        name = name,
        url = url,
    )
}
