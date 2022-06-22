package com.mrkevin574.starwars.domain

import com.mrkevin574.starwars.data.repository.StarWarsProvider
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val provider: StarWarsProvider
) {

}