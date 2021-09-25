package com.benboonya.pokemoninfo.pokemon

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.benboonya.pokemoninfo.common.getPokemonDetailRoute
import com.benboonya.pokemoninfo.common.ui.PaginatedList
import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListViewModel

@Composable
fun PokemonScreen(
    openDrawer: () -> Unit,
    viewModel: PokemonListViewModel,
    navController: NavController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Pokemon") },
                navigationIcon = {
                    IconButton(onClick = { openDrawer() }) {
                        Icon(Icons.Filled.Menu, "Drawer")
                    }
                })
        },
        content = {
            PaginatedList(viewModel.pokemonListResult)
            {
                navController.navigate(getPokemonDetailRoute(it))
            }
        }
    )
}

