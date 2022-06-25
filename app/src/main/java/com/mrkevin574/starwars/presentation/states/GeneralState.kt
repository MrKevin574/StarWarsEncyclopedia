package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.*
import com.mrkevin574.starwars.util.ErrorStarwarsAPI

sealed class GeneralState(var data: List<Any>, var error: ErrorStarwarsAPI = ErrorStarwarsAPI()) {
    class FilmsState(
        data: List<Film> = emptyList(),
        error: ErrorStarwarsAPI = ErrorStarwarsAPI()
    ) : GeneralState(data, error)

    class PeoplesState(
        data: List<People> = emptyList(),
        error: ErrorStarwarsAPI = ErrorStarwarsAPI()
    ) : GeneralState(data, error)

    class PlanetsState(
        data: List<Planet> = emptyList(),
        error: ErrorStarwarsAPI = ErrorStarwarsAPI()
    ) : GeneralState(data, error)

    class SpeciesState(
        data: List<Specie> = emptyList(),
        error: ErrorStarwarsAPI = ErrorStarwarsAPI()
    ) : GeneralState(data, error)

    class StarshipsState(
        data: List<Starship> = emptyList(),
        error: ErrorStarwarsAPI = ErrorStarwarsAPI()
    ) : GeneralState(data, error)

    class VehiclesState(
        data: List<Vehicle> = emptyList(),
        error: ErrorStarwarsAPI = ErrorStarwarsAPI()
    ) : GeneralState(data, error)
}
