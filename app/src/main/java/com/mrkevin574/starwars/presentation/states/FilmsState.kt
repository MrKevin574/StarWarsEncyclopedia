package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Film
import com.mrkevin574.starwars.util.ErrorStarwarsAPI

data class FilmsState(
    var films : List<Film> = emptyList(),
    var error : ErrorStarwarsAPI = ErrorStarwarsAPI()
    )
