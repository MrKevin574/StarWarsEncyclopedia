package com.mrkevin574.starwars.presentation.screens.vehicles

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
import com.mrkevin574.starwars.presentation.states.VehiclesState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun VehicleScreen(
    viewModel: StarWarsViewModel = hiltViewModel(),
    navController: NavHostController
)
{
    val vehicleState = viewModel.vehicles.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OptionSearch(
                label = stringResource(id = R.string.search_people),
                onSearch = { viewModel.onEvent(Event.SearchPeople(it)) }
            )
        },
        content = { paddingValues ->
            ContentVehicles(
                paddingValues = paddingValues,
                vehiclesState = vehicleState,
                navController = navController
            )
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun ContentVehicles(
    vehiclesState: VehiclesState,
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    if (!vehiclesState.error.isError && vehiclesState.vehicles.isEmpty()) {
        Loading(paddingValues)
    } else if (vehiclesState.error.isError) {
        ErrorMessageScreen(message = vehiclesState.error.errorMessage)
    } else {
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.background(Black700))
        {
            items(vehiclesState.vehicles)
            {
                GeneralCard(title = it.name) {
                    val route = Screens.VehiclesDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }
}