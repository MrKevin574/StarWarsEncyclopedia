package com.mrkevin574.starwars.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mrkevin574.starwars.presentation.screens.MainScreen
import com.mrkevin574.starwars.presentation.screens.people.PeopleDetailScreen
import com.mrkevin574.starwars.presentation.screens.planet.PlanetDetailScreen
import com.mrkevin574.starwars.presentation.screens.species.SpeciesDetailScreen
import com.mrkevin574.starwars.presentation.screens.starships.StarshipsDetailScreen
import com.mrkevin574.starwars.presentation.screens.vehicles.VehiclesDetailScreen
import com.mrkevin574.starwars.util.Routes
import com.mrkevin574.starwars.util.StarWarsAPI

@Composable
fun StarwarsNavigation()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN)
    {
        composable(Routes.MAIN_SCREEN) { MainScreen(navController = navController) }
        composable(Routes.FILMS_DETAIL_SCREEN) { backStackStrategy ->
            val filmJson = backStackStrategy.arguments?.getString(StarWarsAPI.FILMS)
        }
        composable(Routes.PEOPLE_DETAIL_SCREEN) { PeopleDetailScreen() }
        composable(Routes.PLANET_DETAIL_SCREEN) { PlanetDetailScreen() }
        composable(Routes.SPECIES_DETAIL_SCREEN) { SpeciesDetailScreen() }
        composable(Routes.STARSHIPS_DETAIL_SCREEN) { StarshipsDetailScreen() }
        composable(Routes.VEHICLES_DETAIL_SCREEN) { VehiclesDetailScreen() }
    }
}