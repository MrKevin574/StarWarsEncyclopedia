package com.mrkevin574.starwars.presentation.states

import com.mrkevin574.starwars.domain.model.Starship

data class StarshipsState(
    var starships : List<Starship> = emptyList()
)
