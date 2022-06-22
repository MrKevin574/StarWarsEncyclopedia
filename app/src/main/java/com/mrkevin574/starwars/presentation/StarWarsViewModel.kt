package com.mrkevin574.starwars.presentation

import androidx.compose.runtime.mutableStateOf
import com.mrkevin574.starwars.domain.StarWarsRepository
import com.mrkevin574.starwars.domain.model.People
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val repository: StarWarsRepository
) {

    fun onEvent(event: Event)
    {
        when(event)
        {
            is Event.SearchFilm -> {

            }
            is Event.SearchPeople -> {

            }
            is Event.SearchPlanet -> {

            }
            is Event.SearchSpecie -> {

            }
            is Event.SearchStarship -> {

            }
            is Event.SearchVehicle -> {

            }
        }
    }

}