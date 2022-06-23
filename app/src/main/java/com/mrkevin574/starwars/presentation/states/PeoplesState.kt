package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.People
import com.mrkevin574.starwars.util.ErrorStarwarsAPI

data class PeoplesState(
    var peoples : List<People> = emptyList(),
    var error : ErrorStarwarsAPI = ErrorStarwarsAPI()
)
