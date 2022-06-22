package com.mrkevin574.starwars.presentation

sealed class Event()
{
    data class SearchPeople(val people : String) : Event()
    data class SearchFilm(val film : String) : Event()
    data class SearchPlanet(val planet : String) : Event()
    data class SearchSpecie(val specie : String) : Event()
    data class SearchStarship(val starship : String) : Event()
    data class SearchVehicle(val vehicle : String) : Event()
}
