package com.mrkevin574.starwars.presentation

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

    val peoples = mutableStateOf(GeneralState.PeoplesState())

    val films = mutableStateOf(GeneralState.FilmsState())

    val planets = mutableStateOf(GeneralState.PlanetsState())

    val species = mutableStateOf(GeneralState.SpeciesState())

    val starships = mutableStateOf(GeneralState.StarshipsState())

    val vehicles = mutableStateOf(GeneralState.VehiclesState())

    init {
        viewModelScope.launch {

            when(val filmsResponse = repository.getAllFilms())
            {
                is Resource.Error -> {
                    films.value = GeneralState.FilmsState(
                        emptyList(),
                        ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = filmsResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    films.value = GeneralState.FilmsState(filmsResponse.data!!)
                }
            }

            when(val peoplesResponse = repository.getAllPeoples())
            {
                is Resource.Error -> {
                    peoples.value = GeneralState.PeoplesState(
                        emptyList(),
                        ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = peoplesResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    peoples.value = GeneralState.PeoplesState(peoplesResponse.data!!)
                }
            }



            when(val planetsResponse = repository.getAllPlanets())
            {
                is Resource.Error -> {
                    planets.value = GeneralState.PlanetsState(
                        emptyList(),
                        ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = planetsResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    planets.value = GeneralState.PlanetsState(planetsResponse.data!!)
                }
            }

            when(val speciesResponse = repository.getAllSpecies())
            {
                is Resource.Error -> {
                    species.value = GeneralState.SpeciesState(
                        emptyList(),
                        ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = speciesResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    species.value = GeneralState.SpeciesState(speciesResponse.data!!)
                }
            }

            when(val starshipsResponse = repository.getAllStarships())
            {
                is Resource.Error -> {
                    starships.value = GeneralState.StarshipsState(
                        emptyList(),
                        ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = starshipsResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    starships.value = GeneralState.StarshipsState(starshipsResponse.data!!)
                }
            }

            when(val vehiclesResponse = repository.getAllVehicles())
            {
                is Resource.Error -> {
                    vehicles.value = GeneralState.VehiclesState(
                        emptyList(),
                        ErrorStarwarsAPI(
                            isError = true,
                            errorMessage = vehiclesResponse.message!!
                        )
                    )
                }
                is Resource.Success -> {
                    vehicles.value = GeneralState.VehiclesState(vehiclesResponse.data!!)
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
                            films.value = GeneralState.FilmsState(
                                emptyList(),
                                ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = filmsResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            films.value = GeneralState.FilmsState(filmsResponse.data!!)
                        }
                    }
                }
                is Event.SearchPeople -> {
                    when(val peoplesResponse = repository.searchPeople(event.people))
                    {
                        is Resource.Error -> {
                            peoples.value = GeneralState.PeoplesState(
                                emptyList(),
                                ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = peoplesResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            peoples.value = GeneralState.PeoplesState(peoplesResponse.data!!)
                        }
                    }
                }
                is Event.SearchPlanet -> {
                    when(val planetsResponse = repository.searchPlanet(event.planet))
                    {
                        is Resource.Error -> {
                            planets.value = GeneralState.PlanetsState(
                                emptyList(),
                                ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = planetsResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            planets.value = GeneralState.PlanetsState(planetsResponse.data!!)
                        }
                    }
                }
                is Event.SearchSpecie -> {
                    when(val specieResponse = repository.searchSpecie(event.specie))
                    {
                        is Resource.Error -> {
                            species.value = GeneralState.SpeciesState(
                                emptyList(),
                                ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = specieResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            species.value = GeneralState.SpeciesState(specieResponse.data!!)
                        }
                    }
                }
                is Event.SearchStarship -> {
                    when(val starshipsResponse = repository.searchStarship(event.starship))
                    {
                        is Resource.Error -> {
                            starships.value = GeneralState.StarshipsState(
                                emptyList(),
                                error = ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = starshipsResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            starships.value = GeneralState.StarshipsState(starshipsResponse.data!!)
                        }
                    }
                }
                is Event.SearchVehicle -> {
                    when(val vehiclesResponse = repository.searchVehicle(event.vehicle))
                    {
                        is Resource.Error -> {
                            vehicles.value = GeneralState.VehiclesState(
                                emptyList(),
                                ErrorStarwarsAPI(
                                    isError = true,
                                    errorMessage = vehiclesResponse.message!!
                                )
                            )
                        }
                        is Resource.Success -> {
                            vehicles.value = GeneralState.VehiclesState(vehiclesResponse.data!!)
                        }
                    }
                }
            }
        }
    }

}