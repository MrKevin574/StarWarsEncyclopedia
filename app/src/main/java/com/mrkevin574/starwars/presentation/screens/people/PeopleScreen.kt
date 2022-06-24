package com.mrkevin574.starwars.presentation.screens.people

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
import com.mrkevin574.starwars.presentation.states.PeoplesState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun PeopleScreen(
    navController: NavHostController,
    peopleState: PeoplesState
) {

    ContentPeople(
        peopleState = peopleState,
        navController = navController
    )
}

@Composable
fun ContentPeople(
    peopleState: PeoplesState,
    navController: NavHostController,
) {
    if (!peopleState.error.isError && peopleState.peoples.isEmpty()) {
        Loading()
    } else if (peopleState.error.isError) {
        ErrorMessageScreen(message = peopleState.error.errorMessage)
    } else {
        LazyColumn(modifier = Modifier.background(Black700))
        {
            items(peopleState.peoples)
            {
                GeneralCard(title = it.name) {
                    val route = Screens.PeopleDetailScreen.passFilm(Uri.encode(Gson().toJson(it)))
                    navController.navigate(route)
                }
            }
        }
    }
}