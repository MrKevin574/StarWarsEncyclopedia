package com.mrkevin574.starwars.util

object Routes {

    const val MAIN_SCREEN = "main_screen"
    const val FILMS_DETAIL_SCREEN = "films_detail_screen/{${StarWarsAPI.FILMS}}"
    const val PEOPLE_DETAIL_SCREEN = "people_detail_screen/{${StarWarsAPI.PEOPLE}}"
    const val PLANET_DETAIL_SCREEN = "planet_detail_screen/{${StarWarsAPI.PLANETS}}"
    const val SPECIES_DETAIL_SCREEN = "species_detail_screen/{${StarWarsAPI.SPECIES}}"
    const val STARSHIPS_DETAIL_SCREEN = "starships_detail_screen/{${StarWarsAPI.STARSHIPS}}"
    const val VEHICLES_DETAIL_SCREEN = "vehicles_detail_screen/{${StarWarsAPI.VEHICLES}}"
}