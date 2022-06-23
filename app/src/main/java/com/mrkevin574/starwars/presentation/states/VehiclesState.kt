package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Vehicle
import com.mrkevin574.starwars.util.ErrorStarwarsAPI

data class VehiclesState(
    var vehicles : List<Vehicle> = emptyList(),
    var error : ErrorStarwarsAPI = ErrorStarwarsAPI()
)
