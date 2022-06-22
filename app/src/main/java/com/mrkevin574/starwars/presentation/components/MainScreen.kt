package com.mrkevin574.starwars.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.presentation.StarWarsViewModel
import com.mrkevin574.starwars.presentation.film.FilmScreen
import com.mrkevin574.starwars.presentation.people.PeopleScreen
import com.mrkevin574.starwars.presentation.planet.PlanetScreen
import com.mrkevin574.starwars.presentation.species.SpeciesScreen
import com.mrkevin574.starwars.presentation.starships.StarshipsScreen
import com.mrkevin574.starwars.presentation.ui.theme.StarWarsTheme

@Composable
fun MainScreen(
    viewModel: StarWarsViewModel = hiltViewModel()
) {
    StarWarsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HorizontalPager()
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPager() {
    val pagerState = rememberPagerState()
    val pages = listOf(
        stringResource(R.string.films),
        stringResource(R.string.peoples),
        stringResource(R.string.planets),
        stringResource(R.string.species),
        stringResource(R.string.starships)
    )

    Column {

        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title, color = Color.White) },
                    selected = pagerState.currentPage == index,
                    onClick = {

                    }
                )
            }


        }

        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> FilmScreen()
                1 -> PeopleScreen()
                2 -> PlanetScreen()
                3 -> SpeciesScreen()
                4 -> StarshipsScreen()
            }
        }
    }


}