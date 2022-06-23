package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Specie
import com.mrkevin574.starwars.util.ErrorStarwarsAPI

data class SpeciesState(
    var species : List<Specie> = emptyList(),
    var error : ErrorStarwarsAPI = ErrorStarwarsAPI()
)
