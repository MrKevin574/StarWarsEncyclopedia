package com.mrkevin574.starwars.presentation.screens.planet

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.presentation.Event
import com.mrkevin574.starwars.presentation.StarWarsViewModel
import com.mrkevin574.starwars.presentation.components.ErrorMessageScreen
import com.mrkevin574.starwars.presentation.components.Loading
import com.mrkevin574.starwars.presentation.components.OptionSearch
import com.mrkevin574.starwars.presentation.screens.people.ContentPeople
import com.mrkevin574.starwars.presentation.screens.people.PeopleCard
import com.mrkevin574.starwars.presentation.states.PeoplesState
import com.mrkevin574.starwars.presentation.states.PlanetsState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun PlanetScreen(
    viewModel: StarWarsViewModel = hiltViewModel(),
    navController: NavHostController
)
{
    val planetState = viewModel.planets.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OptionSearch(
                label = stringResource(id = R.string.search_planet),
                onSearch = { viewModel.onEvent(Event.SearchPeople(it)) }
            )
        },
        content = { paddingValues ->
            ContentPlanet(
                paddingValues = paddingValues,
                planetState = planetState,
                navController = navController
            )
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun ContentPlanet(
    planetState: PlanetsState,
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    if (!planetState.error.isError && planetState.planets.isEmpty()) {
        Loading(paddingValues)
    } else if (planetState.error.isError) {
        ErrorMessageScreen(message = planetState.error.errorMessage)
    } else {
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.background(Black700))
        {
            items(planetState.planets)
            {
                PlanetCard(planet = it) {
                    val route = Screens.PlanetDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }
}