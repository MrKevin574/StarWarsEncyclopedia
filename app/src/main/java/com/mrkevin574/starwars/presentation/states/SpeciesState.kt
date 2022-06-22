package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Specie

data class SpeciesState(
    var species : List<Specie> = emptyList()
)
