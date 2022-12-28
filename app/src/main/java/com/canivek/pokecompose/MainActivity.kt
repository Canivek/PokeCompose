package com.canivek.pokecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canivek.pokecompose.ui.theme.PokeComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<PokemonsViewModel> {
        PokeApplication.instance.viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val pokemons by viewModel.pokemons.observeAsState(initial = emptyList())
                    Content(pokemons = pokemons)
                }
            }
        }
    }
}

@Composable
private fun Content(pokemons: List<Pokemon>) {
    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonRow(pokemon = pokemon)
        }
    }
}

@Composable
private fun PokemonRow(pokemon: Pokemon) {
    Text(
        text = pokemon.name,
        modifier = Modifier.padding(16.dp),
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokeComposeTheme {
        Greeting("Android")
    }
}
