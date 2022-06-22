package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Film

data class FilmsState(
    var films : List<Film> = emptyList()
    )
