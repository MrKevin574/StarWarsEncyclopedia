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
            _peoples.value = peoples.value.copy(
                peoples = repository.getAllPeoples()
            )
            _films.value = films.value.copy(
                films = repository.getAllFilms()
            )
            _planets.value = planets.value.copy(
                planets = repository.getAllPlanets()
            )
            _species.value = species.value.copy(
                species = repository.getAllSpecies()
            )
            _starships.value = starships.value.copy(
                starships = repository.getAllStarships()
            )
            _vehicles.value = vehicles.value.copy(
                vehicles = repository.getAllVehicles()
            )
        }
    }

    fun onEvent(event: Event)
    {
        viewModelScope.launch {
            when(event)
            {
                is Event.SearchFilm -> {
                    _films.value = films.value.copy(
                        films = repository.searchFilm(event.film)
                    )

                    Log.w(TAG, "${films.value.films.size}")
                }
                is Event.SearchPeople -> {
                    _peoples.value = peoples.value.copy(
                        peoples = repository.searchPeople(event.people)
                    )
                }
                is Event.SearchPlanet -> {
                    _planets.value = planets.value.copy(
                        planets = repository.searchPlanet(event.planet)
                    )
                }
                is Event.SearchSpecie -> {
                    _species.value = species.value.copy(
                        species = repository.searchSpecie(event.specie)
                    )
                }
                is Event.SearchStarship -> {
                    _starships.value = starships.value.copy(
                        starships = repository.searchStarship(event.starship)
                    )
                }
                is Event.SearchVehicle -> {
                    _vehicles.value = vehicles.value.copy(
                        vehicles = repository.searchVehicle(event.vehicle)
                    )
                }
            }
        }
    }

}