package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Planet

data class PlanetsState(
    var planets : List<Planet> = emptyList()
)
