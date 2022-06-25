package com.mrkevin574.starwars.presentation.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.mrkevin574.starwars.domain.model.*
import com.mrkevin574.starwars.presentation.states.GeneralState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun GeneralContent(state: GeneralState, navController: NavHostController) {

    if(!state.error.isError && state.data.isEmpty())
    {
        Loading()
    }else if(state.error.isError)
    {
        ErrorMessageScreen(message = state.error.errorMessage)
    } else {
        LazyColumn(modifier = Modifier.background(Black700))
        {
            items(state.data)
            {
                when(state)
                {
                    is GeneralState.FilmsState -> {
                        GeneralCard(title = (it as Film).title){
                            val route = Screens.FilmsDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                            navController.navigate(route)
                        }
                    }
                    is GeneralState.PeoplesState -> {
                        GeneralCard(title = (it as People).name) {
                            val route = Screens.PeopleDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                            navController.navigate(route)
                        }
                    }
                    is GeneralState.PlanetsState -> {
                        GeneralCard(title = (it as Planet).name) {
                            val route = Screens.PlanetDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                            navController.navigate(route)
                        }
                    }
                    is GeneralState.SpeciesState -> {
                        GeneralCard(title = (it as Specie).name) {
                            val route = Screens.SpeciesDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                            navController.navigate(route)
                        }
                    }
                    is GeneralState.StarshipsState -> {
                        GeneralCard(title = (it as Starship).name) {
                            val route = Screens.StarshipsDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                            navController.navigate(route)
                        }
                    }
                    is GeneralState.VehiclesState -> {
                        GeneralCard(title = (it as Vehicle).name) {
                            val route = Screens.VehiclesDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                            navController.navigate(route)
                        }
                    }
                }

            }
        }
    }

}