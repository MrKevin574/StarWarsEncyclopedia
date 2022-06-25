package com.mrkevin574.starwars.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrkevin574.starwars.domain.StarWarsRepository
import com.mrkevin574.starwars.presentation.states.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val repository: StarWarsRepository
) : ViewModel(){

    private val TAG = "viewmodel_call"

    private val _peoples = mutableStateOf(PeoplesState())
    val peoples : State<PeoplesState> = _peoples

    private val _films = mutableStateOf(FilmsState())
    val films : State<FilmsState> = _films

    private val _planets = mutableStateOf(PlanetsState())
    val planets : State<PlanetsState> = _planets

    private val _species = mutableStateOf(SpeciesState())
    val species : State<SpeciesState> = _species

    private val _starships = mutableStateOf(StarshipsState())
    val starships : State<StarshipsState> = _starships

    private val _vehicles = mutableStateOf(VehiclesState())
    val vehicles : State<VehiclesState> = _vehicles

    init {
        viewModelScope.launch {
            _peoples.value = peoples.value.apply {
                peoples = repository.getAllPeoples()
                Log.v(TAG, "PEOPLES SIZE: ${peoples.size}")
            }
            _films.value = films.value.apply {
                films = repository.getAllFilms()
                Log.v(TAG, "FILMS SIZE: ${films.size}")
            }
            _planets.value = planets.value.apply {
                planets = repository.getAllPlanets()
                Log.v(TAG, "PLANETS SIZE ${planets}")
            }
            _species.value = species.value.apply {
                species = repository.getAllSpecies()
                Log.v(TAG, "SPECIES SIZE ${species.toString()}")
            }
            _starships.value = starships.value.apply {
                starships = repository.getAllStarships()
                Log.v(TAG, "STARSHIPS SIZE ${starships.size}")
            }
            _vehicles.value = vehicles.value.apply {
                vehicles = repository.getAllVehicles()
                Log.v(TAG, "VEHICLES SIZE ${vehicles.size}")
            }
        }
    }

    fun onEvent(event: Event)
    {
        viewModelScope.launch {
            when(event)
            {
                is Event.SearchFilm -> {
                    repository.searchFilm(event.film)
                }
                is Event.SearchPeople -> {
                    repository.searchPeople(event.people)
                }
                is Event.SearchPlanet -> {
                    repository.searchPlanet(event.planet)
                }
                is Event.SearchSpecie -> {
                    repository.searchSpecie(event.specie)
                }
                is Event.SearchStarship -> {
                    repository.searchStarship(event.starship)
                }
                is Event.SearchVehicle -> {
                    repository.searchVehicle(event.vehicle)
                }
            }
        }
    }

}