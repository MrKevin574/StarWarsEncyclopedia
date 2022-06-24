package com.mrkevin574.starwars.presentation.screens.film

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.mrkevin574.starwars.presentation.Event
import com.mrkevin574.starwars.presentation.StarWarsViewModel
import com.mrkevin574.starwars.presentation.components.Loading
import com.mrkevin574.starwars.presentation.components.OptionSearch
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.presentation.components.ErrorMessageScreen
import com.mrkevin574.starwars.presentation.states.FilmsState
import com.mrkevin574.starwars.util.Screens

@Composable
fun FilmScreen(
    viewModel: StarWarsViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val filmsState = viewModel.films.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { OptionSearch(
            label = stringResource(id = R.string.search_film),
            onSearch = { viewModel.onEvent(Event.SearchFilm(it)) }
        ) },
        content = { paddingValues ->
            ContentFilm(
                paddingValues = paddingValues,
                filmsState = filmsState,
                navController = navController
            )
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun ContentFilm(paddingValues: PaddingValues, filmsState: FilmsState, navController: NavHostController) {

    if(!filmsState.error.isError && filmsState.films.isEmpty())
    {
        Loading(paddingValues)
    }else if(filmsState.error.isError)
    {
        ErrorMessageScreen(message = filmsState.error.errorMessage)
    } else {
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.background(Black700))
        {
            items(filmsState.films)
            {
                FilmCard(film = it){
                    val route = Screens.FilmsDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }

}




