package com.mrkevin574.starwars.presentation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.mrkevin574.starwars.domain.model.*
import com.mrkevin574.starwars.presentation.screens.MainScreen
import com.mrkevin574.starwars.presentation.screens.FilmDetailScreen
import com.mrkevin574.starwars.presentation.screens.PeopleDetailScreen
import com.mrkevin574.starwars.presentation.screens.PlanetDetailScreen
import com.mrkevin574.starwars.presentation.screens.SpeciesDetailScreen
import com.mrkevin574.starwars.presentation.screens.StarshipsDetailScreen
import com.mrkevin574.starwars.presentation.screens.VehiclesDetailScreen
import com.mrkevin574.starwars.util.Screens

@Composable
fun StarwarsNavigation()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MainScreen.route)
    {
        composable(Screens.MainScreen.route) { MainScreen(navController = navController) }
        composable(
            Screens.FilmsDetailScreen.route
        ) { backStackStrategy ->
            val argEncode = backStackStrategy.arguments?.getString(Screens.FilmsDetailScreen.argument)
            val argDecode = Uri.decode(argEncode)
            FilmDetailScreen(Gson().fromJson(argDecode, Film::class.java))
        }
        composable(Screens.PeopleDetailScreen.route) { backStackStrategy ->
            val argEncode = backStackStrategy.arguments?.getString(Screens.PeopleDetailScreen.argument)
            val argDecode = Uri.decode(argEncode)
            PeopleDetailScreen(Gson().fromJson(argDecode, People::class.java))
        }
        composable(Screens.PlanetDetailScreen.route) { backStackStrategy ->
            val argEncode = backStackStrategy.arguments?.getString(Screens.PlanetDetailScreen.argument)
            val argDecode = Uri.decode(argEncode)
            PlanetDetailScreen(Gson().fromJson(argDecode, Planet::class.java))
        }
        composable(Screens.SpeciesDetailScreen.route) { backStackStrategy ->
            val argEncode = backStackStrategy.arguments?.getString(Screens.SpeciesDetailScreen.argument)
            val argDecode = Uri.decode(argEncode)
            SpeciesDetailScreen(Gson().fromJson(argDecode, Specie::class.java))
        }
        composable(Screens.StarshipsDetailScreen.route) {backStackStrategy ->
            val argEncode = backStackStrategy.arguments?.getString(Screens.StarshipsDetailScreen.argument)
            val argDecode = Uri.decode(argEncode)
            StarshipsDetailScreen(Gson().fromJson(argDecode, Starship::class.java))
        }
        composable(Screens.VehiclesDetailScreen.route) { backStackStrategy ->
            val argEncode = backStackStrategy.arguments?.getString(Screens.VehiclesDetailScreen.argument)
            val argDecode = Uri.decode(argEncode)
            VehiclesDetailScreen(Gson().fromJson(argDecode, Vehicle::class.java))
        }
    }
}