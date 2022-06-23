package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Planet
import com.mrkevin574.starwars.util.ErrorStarwarsAPI

data class PlanetsState(
    var planets : List<Planet> = emptyList(),
    var error : ErrorStarwarsAPI = ErrorStarwarsAPI()
)
