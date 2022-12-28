package com.canivek.pokecompose

import android.app.Application
import com.canivek.pokecompose.pokeapi.PokeApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PokeApplication : Application() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    private val pokeApi: PokeApi = retrofit.create(PokeApi::class.java)
    val pokeRepository = PokeRepository(pokeApi = pokeApi)
    val viewModelFactory = ViewModelFactory(
        pokemonRepository = pokeRepository
    )

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: PokeApplication
    }
}
