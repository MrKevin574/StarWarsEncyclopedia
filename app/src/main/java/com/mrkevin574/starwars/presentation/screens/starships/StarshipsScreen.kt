package com.mrkevin574.starwars.presentation.screens.starships

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
import com.mrkevin574.starwars.presentation.states.StarshipsState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun StarshipsScreen(
    viewModel: StarWarsViewModel = hiltViewModel(),
    navController: NavHostController
)
{
    val starshipsState = viewModel.starships.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OptionSearch(
                label = stringResource(id = R.string.search_people),
                onSearch = { viewModel.onEvent(Event.SearchPeople(it)) }
            )
        },
        content = { paddingValues ->
            ContentStarships(
                paddingValues = paddingValues,
                starshipState = starshipsState,
                navController = navController
            )
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun ContentStarships(
    starshipState: StarshipsState,
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    if (!starshipState.error.isError && starshipState.starships.isEmpty()) {
        Loading(paddingValues)
    } else if (starshipState.error.isError) {
        ErrorMessageScreen(message = starshipState.error.errorMessage)
    } else {
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.background(Black700))
        {
            items(starshipState.starships)
            {
                GeneralCard(title = it.name) {
                    val route = Screens.StarshipsDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }
}