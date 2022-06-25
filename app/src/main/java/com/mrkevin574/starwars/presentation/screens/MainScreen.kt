package com.mrkevin574.starwars.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.google.accompanist.pager.HorizontalPager
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.presentation.Event
import com.mrkevin574.starwars.presentation.StarWarsViewModel
import com.mrkevin574.starwars.presentation.components.GeneralContent
import com.mrkevin574.starwars.presentation.components.OptionSearch
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.presentation.ui.theme.StarWarsTheme
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: StarWarsViewModel = hiltViewModel()
) {
    StarWarsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val pagerState = rememberPagerState()
            Scaffold(
                bottomBar = { OptionSearch(label = "Search", onSearch = {
                    when(pagerState.currentPage)
                    {
                        0 -> {
                            viewModel.onEvent(Event.SearchFilm(it))
                        }
                        1 -> {
                            viewModel.onEvent(Event.SearchPeople(it))
                        }
                        2 ->{
                            viewModel.onEvent(Event.SearchPlanet(it))
                        }
                        3 -> {
                            viewModel.onEvent(Event.SearchSpecie(it))
                        }
                        4 -> {
                            viewModel.onEvent(Event.SearchStarship(it))
                        }
                        5 -> {
                            viewModel.onEvent(Event.SearchVehicle(it))
                        }
                    }
                }) }
            ) { paddingValues ->
                HorizontalPager(navController, paddingValues, pagerState, viewModel)
            }

        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPager(
    navController: NavHostController,
    paddingValues: PaddingValues,
    pagerState : PagerState,
    viewModel: StarWarsViewModel) {
    val scope = rememberCoroutineScope()

    val pages = listOf(
        stringResource(R.string.films),
        stringResource(R.string.peoples),
        stringResource(R.string.planets),
        stringResource(R.string.species),
        stringResource(R.string.starships),
        stringResource(R.string.vehicles)
    )

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {

        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            },
            modifier = Modifier.height(80.dp)
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(text = title,
                            color = YellowStarWars,
                            fontFamily = starWarsFont
                        )
                           },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch { pagerState.animateScrollToPage(index) }
                    }
                )
            }


        }

        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize().background(Black700)
        ) { page ->
            when (page) {
                0 -> GeneralContent(
                    navController = navController,
                    state = viewModel.films.value
                )
                1 -> GeneralContent(
                    navController = navController,
                    state = viewModel.peoples.value
                )
                2 -> GeneralContent(
                    navController = navController,
                    state = viewModel.planets.value
                )
                3 -> GeneralContent(
                    navController = navController,
                    state = viewModel.species.value
                )
                4 -> GeneralContent(
                    navController = navController,
                    state = viewModel.starships.value
                )
                5 -> GeneralContent(
                    navController = navController,
                    state = viewModel.vehicles.value
                )
            }
        }
    }


}