package com.canivek.pokecompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class ViewModelFactory(
    private val pokemonRepository: PokeRepository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(PokemonsViewModel::class.java)) {
            return PokemonsViewModel(pokemonRepository) as T
        }

        throw IllegalArgumentException("")
    }
}
