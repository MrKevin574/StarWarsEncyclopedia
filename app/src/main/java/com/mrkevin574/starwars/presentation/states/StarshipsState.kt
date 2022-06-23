package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Starship
import com.mrkevin574.starwars.util.ErrorStarwarsAPI

data class StarshipsState(
    var starships : List<Starship> = emptyList(),
    var error : ErrorStarwarsAPI = ErrorStarwarsAPI()
)
