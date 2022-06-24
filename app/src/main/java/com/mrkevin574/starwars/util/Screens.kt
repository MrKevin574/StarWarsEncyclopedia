package com.mrkevin574.starwars.util

sealed class Screens(val route : String,val argument : String = "") {
    object MainScreen : Screens("main_screen")
    object FilmsDetailScreen : Screens("films_detail_screen/{${StarWarsAPI.FILMS}}", StarWarsAPI.FILMS)
    {
        fun passFilm(argument : String) = "films_detail_screen/$argument"
    }
    object PeopleDetailScreen : Screens("people_detail_screen/{${StarWarsAPI.PEOPLE}}", StarWarsAPI.PEOPLE)
    {
        fun passFilm(argument : String) = "people_detail_screen/$argument"
    }
    object PlanetDetailScreen : Screens("planet_detail_screen/{${StarWarsAPI.PLANETS}}", StarWarsAPI.PLANETS)
    {
        fun passFilm(argument : String) = "planet_detail_screen/$argument"
    }
    object SpeciesDetailScreen : Screens("species_detail_screen/{${StarWarsAPI.SPECIES}}", StarWarsAPI.SPECIES)
    {
        fun passFilm(argument : String) = "species_detail_screen/$argument"
    }
    object StarshipsDetailScreen : Screens("starships_detail_screen/{${StarWarsAPI.STARSHIPS}}", StarWarsAPI.STARSHIPS)
    {
        fun passFilm(argument : String) = "starships_detail_screen/$argument"
    }
    object VehiclesDetailScreen : Screens("vehicles_detail_screen/{${StarWarsAPI.VEHICLES}}", StarWarsAPI.VEHICLES)
    {
        fun passFilm(argument : String) = "vehicles_detail_screen/$argument"
    }
}