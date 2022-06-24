package com.mrkevin574.starwars.presentation.screens.planet

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.presentation.Event
import com.mrkevin574.starwars.presentation.StarWarsViewModel
import com.mrkevin574.starwars.presentation.components.ErrorMessageScreen
import com.mrkevin574.starwars.presentation.components.GeneralCard
import com.mrkevin574.starwars.presentation.components.Loading
import com.mrkevin574.starwars.presentation.components.OptionSearch
import com.mrkevin574.starwars.presentation.states.PlanetsState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun PlanetScreen(
    navController: NavHostController,
    planetState: PlanetsState
)
{
    ContentPlanet(
        planetState = planetState,
        navController = navController
    )
}

@Composable
fun ContentPlanet(
    planetState: PlanetsState,
    navController: NavHostController,
) {
    if (!planetState.error.isError && planetState.planets.isEmpty()) {
        Loading()
    } else if (planetState.error.isError) {
        ErrorMessageScreen(message = planetState.error.errorMessage)
    } else {
        LazyColumn(modifier = Modifier.background(Black700))
        {
            items(planetState.planets)
            {
                GeneralCard(title = it.name) {
                    val route = Screens.PlanetDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }
}