package com.mrkevin574.starwars.presentation.screens.people

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
import com.mrkevin574.starwars.presentation.states.PeoplesState
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.util.Screens

@Composable
fun PeopleScreen(
    viewModel: StarWarsViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val peopleState = viewModel.peoples.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OptionSearch(
                label = stringResource(id = R.string.search_people),
                onSearch = { viewModel.onEvent(Event.SearchPeople(it)) }
            )
        },
        content = { paddingValues ->
            ContentPeople(
                paddingValues = paddingValues,
                peopleState = peopleState,
                navController = navController
            )
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun ContentPeople(
    peopleState: PeoplesState,
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    if (!peopleState.error.isError && peopleState.peoples.isEmpty()) {
        Loading(paddingValues)
    } else if (peopleState.error.isError) {
        ErrorMessageScreen(message = peopleState.error.errorMessage)
    } else {
        LazyColumn(contentPadding = paddingValues, modifier = Modifier.background(Black700))
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