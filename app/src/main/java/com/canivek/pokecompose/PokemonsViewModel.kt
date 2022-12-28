package com.canivek.pokecompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class PokemonsViewModel(
    private val pokemonRepository: PokeRepository,
) : ViewModel() {

    val pokemons: LiveData<List<Pokemon>> = liveData {
        try {
            emit(pokemonRepository.getPokemons())
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}
