package com.mrkevin574.starwars.presentation.screens.vehicles

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
import com.mrkevin574.starwars.presentation.states.VehiclesState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun VehicleScreen(
    navController: NavHostController,
    vehicleState: VehiclesState
)
{
    ContentVehicles(
        vehiclesState = vehicleState,
        navController = navController
    )
}

@Composable
fun ContentVehicles(
    vehiclesState: VehiclesState,
    navController: NavHostController,
) {
    if (!vehiclesState.error.isError && vehiclesState.vehicles.isEmpty()) {
        Loading()
    } else if (vehiclesState.error.isError) {
        ErrorMessageScreen(message = vehiclesState.error.errorMessage)
    } else {
        LazyColumn(modifier = Modifier.background(Black700))
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