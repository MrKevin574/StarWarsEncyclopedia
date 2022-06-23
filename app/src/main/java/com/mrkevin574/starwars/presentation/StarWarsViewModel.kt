package com.mrkevin574.starwars.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrkevin574.starwars.domain.StarWarsRepository
import com.mrkevin574.starwars.presentation.states.*
import com.mrkevin574.starwars.util.ErrorStarwarsAPI
import com.mrkevin574.starwars.util.Resource
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

            when(val peoplesResponse = repository.getAllPeoples())
            {
                is Resource.Error -> {
                    _peoples.value = peoples.value.copy(
                        error = ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = peoplesResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    _peoples.value = peoples.value.copy(
                        peoples = peoplesResponse.data!!
                    )
                }
            }

            when(val filmsResponse = repository.getAllFilms())
            {
                is Resource.Error -> {
                    _films.value = films.value.copy(
                        error = ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = filmsResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    _films.value = films.value.copy(
                        films = filmsResponse.data!!
                    )
                }
            }

            when(val planetsResponse = repository.getAllPlanets())
            {
                is Resource.Error -> {
                    _planets.value = planets.value.copy(
                        error = ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = planetsResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    _planets.value = planets.value.copy(
                        planets = planetsResponse.data!!
                    )
                }
            }

            when(val speciesResponse = repository.getAllSpecies())
            {
                is Resource.Error -> {
                    _species.value = species.value.copy(
                        error = ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = speciesResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    _species.value = species.value.copy(
                        species = speciesResponse.data!!
                    )
                }
            }

            when(val starshipsResponse = repository.getAllStarships())
            {
                is Resource.Error -> {
                    _starships.value = starships.value.copy(
                        error = ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = starshipsResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    _starships.value = starships.value.copy(
                        starships = starshipsResponse.data!!
                    )
                }
            }

            when(val vehiclesResponse = repository.getAllVehicles())
            {
                is Resource.Error -> {
                    _vehicles.value = vehicles.value.copy(
                        error = ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = vehiclesResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    _vehicles.value = vehicles.value.copy(
                        vehicles = vehiclesResponse.data!!
                    )
                }
            }

        }
    }

    fun onEvent(event: Event)
    {
        viewModelScope.launch {
            when(event)
            {
                is Event.SearchFilm -> {
                    when(val filmsResponse = repository.searchFilm(event.film))
                    {
                        is Resource.Error -> {
                            _films.value = films.value.copy(
                                error = ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = filmsResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            _films.value = films.value.copy(
                                films = filmsResponse.data!!,
                                error = ErrorStarwarsAPI()
                            )
                        }
                    }
                }
                is Event.SearchPeople -> {
                    when(val peoplesResponse = repository.searchPeople(event.people))
                    {
                        is Resource.Error -> {
                            _peoples.value = peoples.value.copy(
                                error = ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = peoplesResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            _peoples.value = peoples.value.copy(
                                peoples = peoplesResponse.data!!,
                                error = ErrorStarwarsAPI()
                            )
                        }
                    }
                }
                is Event.SearchPlanet -> {
                    when(val planetsResponse = repository.searchPlanet(event.planet))
                    {
                        is Resource.Error -> {
                            _planets.value = planets.value.copy(
                                error = ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = planetsResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            _planets.value = planets.value.copy(
                                planets = planetsResponse.data!!,
                                error = ErrorStarwarsAPI()
                            )
                        }
                    }
                }
                is Event.SearchSpecie -> {
                    when(val specieResponse = repository.searchSpecie(event.specie))
                    {
                        is Resource.Error -> {
                            _species.value = species.value.copy(
                                error = ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = specieResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            _species.value = species.value.copy(
                                species = specieResponse.data!!,
                                error = ErrorStarwarsAPI()
                            )
                        }
                    }
                }
                is Event.SearchStarship -> {
                    when(val starshipsResponse = repository.searchStarship(event.starship))
                    {
                        is Resource.Error -> {
                            _starships.value = starships.value.copy(
                                error = ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = starshipsResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            _starships.value = starships.value.copy(
                                starships = starshipsResponse.data!!,
                                error = ErrorStarwarsAPI()
                            )
                        }
                    }
                }
                is Event.SearchVehicle -> {
                    when(val vehiclesResponse = repository.searchVehicle(event.vehicle))
                    {
                        is Resource.Error -> {
                            _vehicles.value = vehicles.value.copy(
                                error = ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = vehiclesResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            _vehicles.value = vehicles.value.copy(
                                vehicles = vehiclesResponse.data!!,
                                error = ErrorStarwarsAPI()
                            )
                        }
                    }
                }
            }
        }
    }

}