package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.People

data class PeoplesState(
    var peoples : List<People> = emptyList()
)
