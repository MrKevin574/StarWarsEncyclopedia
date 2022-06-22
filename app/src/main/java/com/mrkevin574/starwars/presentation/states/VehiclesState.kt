package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Vehicle

data class VehiclesState(
    var vehicles : List<Vehicle> = emptyList()
)
