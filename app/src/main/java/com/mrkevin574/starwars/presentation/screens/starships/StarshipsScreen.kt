package com.mrkevin574.starwars.presentation.screens.starships

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
import com.mrkevin574.starwars.presentation.states.StarshipsState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun StarshipsScreen(
    navController: NavHostController,
    starshipState: StarshipsState
)
{
    ContentStarships(
        starshipState = starshipState,
        navController = navController
    )
}

@Composable
fun ContentStarships(
    starshipState: StarshipsState,
    navController: NavHostController,
) {
    if (!starshipState.error.isError && starshipState.starships.isEmpty()) {
        Loading()
    } else if (starshipState.error.isError) {
        ErrorMessageScreen(message = starshipState.error.errorMessage)
    } else {
        LazyColumn(modifier = Modifier.background(Black700))
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