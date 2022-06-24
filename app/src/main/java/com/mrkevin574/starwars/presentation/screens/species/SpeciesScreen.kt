package com.mrkevin574.starwars.presentation.screens.species

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.mrkevin574.starwars.presentation.components.ErrorMessageScreen
import com.mrkevin574.starwars.presentation.components.GeneralCard
import com.mrkevin574.starwars.presentation.components.Loading
import com.mrkevin574.starwars.presentation.states.SpeciesState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun SpeciesScreen(
    navController: NavHostController,
    specieState: SpeciesState
){
    ContentSpecie(
        specieState = specieState,
        navController = navController
    )
}

@Composable
fun ContentSpecie(
    specieState: SpeciesState,
    navController: NavHostController,
) {
    if (!specieState.error.isError && specieState.species.isEmpty()) {
        Loading()
    } else if (specieState.error.isError) {
        ErrorMessageScreen(message = specieState.error.errorMessage)
    } else {
        LazyColumn(modifier = Modifier.background(Black700))
        {
            items(specieState.species)
            {
                GeneralCard(title = it.name) {
                    val route = Screens.SpeciesDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }
}