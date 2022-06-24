package com.mrkevin574.starwars.domain

import android.util.AndroidRuntimeException
import com.mrkevin574.starwars.data.repository.StarWarsProvider
import com.mrkevin574.starwars.data.repository.model.toDomain
import com.mrkevin574.starwars.domain.model.*
import com.mrkevin574.starwars.util.Resource
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val provider: StarWarsProvider
) {
    suspend fun getAllPeoples(): Resource<List<People>> {
        try {
            val response = provider.getAllPeoples()

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error getting people, check your internet connection")
            }

            val result = response.body()!!
                .peoples
                .map {
                    it.toDomain()
                }

            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun getAllFilms(): Resource<List<Film>> {
        try {
            val response = provider.getAllFilms()

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error getting films, check your internet connection")
            }

            val result = response.body()!!
                .films
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }
    }

    suspend fun getAllPlanets(): Resource<List<Planet>> {
        try {
            val response = provider.getAllPlanets()

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error getting planets, check your internet connection")
            }

            val result = response.body()!!
                .planets
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }
    }

    suspend fun getAllSpecies(): Resource<List<Specie>> {
        try {
            val response = provider.getAllSpecies()

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error getting species, check your internet connection")
            }

            val result = response.body()!!
                .species
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun getAllStarships(): Resource<List<Starship>> {
        try {
            val response = provider.getAllStarships()

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error getting starships, check your internet connection")
            }

            val result = response.body()!!
                .starships
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }


    suspend fun getAllVehicles(): Resource<List<Vehicle>> {

        try {
            val response = provider.getAllVehicles()

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error getting vehicles, check your internet connection")
            }

            val result = response.body()!!
                .vehicles
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun searchPeople(people: String): Resource<List<People>> {
        try {
            val response = provider.searchPeople(people)

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error from server")
            } else if (response.body()!!.peoples.isEmpty()) {
                return Resource.Error("$people not found")
            }

            val result = response.body()!!
                .peoples
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun searchFilm(film: String): Resource<List<Film>> {
        try {
            val response = provider.searchFilm(film)

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error from server")
            } else if (response.body()!!.films.isEmpty()) {
                return Resource.Error("$film not found")
            }

            val result = response.body()!!
                .films
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun searchPlanet(planet: String): Resource<List<Planet>> {
        try{
            val response = provider.searchPlanet(planet)

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error from server")
            } else if (response.body()!!.planets.isEmpty()) {
                return Resource.Error("$planet not found")
            }

            val result = response.body()!!
                .planets
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        }catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun searchSpecie(specie: String): Resource<List<Specie>> {
        try{
            val response = provider.searchSpecie(specie)

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error from server")
            } else if (response.body()!!.species.isEmpty()) {
                return Resource.Error("$specie not found")
            }

            val result = response.body()!!
                .species
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        }catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun searchStarship(starship: String): Resource<List<Starship>> {
        try{
            val response = provider.searchStarship(starship)

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error from server")
            } else if (response.body()!!.starships.isEmpty()) {
                return Resource.Error("$starship not found")
            }

            val result = response.body()!!
                .starships
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        }catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }

    suspend fun searchVehicle(vehicle: String): Resource<List<Vehicle>> {
        try {
            val response = provider.searchVehicle(vehicle)

            if (!(response.isSuccessful) && response.code() != 200) {
                return Resource.Error("Error from server")
            } else if (response.body()!!.vehicles.isEmpty()) {
                return Resource.Error("$vehicle not found")
            }

            val result = response.body()!!
                .vehicles
                .map {
                    it.toDomain()
                }
            return Resource.Success(result)
        }catch (e: Exception) {
            return Resource.Error("Check your internet connection")
        }

    }
}