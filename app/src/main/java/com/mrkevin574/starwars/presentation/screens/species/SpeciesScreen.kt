package com.mrkevin574.starwars.presentation.screens.species

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
import com.mrkevin574.starwars.presentation.screens.planet.ContentPlanet
import com.mrkevin574.starwars.presentation.screens.planet.PlanetCard
import com.mrkevin574.starwars.presentation.states.PlanetsState
import com.mrkevin574.starwars.presentation.states.SpeciesState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun SpeciesScreen(
    viewModel: StarWarsViewModel = hiltViewModel(),
    navController: NavHostController
)
{
    val speciesState = viewModel.species.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OptionSearch(
                label = stringResource(id = R.string.search_planet),
                onSearch = { viewModel.onEvent(Event.SearchPeople(it)) }
            )
        },
        content = { paddingValues ->
            ContentSpecie(
                paddingValues = paddingValues,
                specieState = speciesState,
                navController = navController
            )
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun ContentSpecie(
    specieState: SpeciesState,
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    if (!specieState.error.isError && specieState.species.isEmpty()) {
        Loading(paddingValues)
    } else if (specieState.error.isError) {
        ErrorMessageScreen(message = specieState.error.errorMessage)
    } else {
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.background(Black700))
        {
            items(specieState.species)
            {
                SpecieCard(specie = it) {
                    val route = Screens.PlanetDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }
}