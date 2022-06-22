package com.mrkevin574.starwars.domain

import com.mrkevin574.starwars.data.repository.StarWarsProvider
import com.mrkevin574.starwars.data.repository.model.toDomain
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val provider: StarWarsProvider
) {
    suspend fun getAllPeoples() = provider.getAllPeoples().map { it.toDomain() }
    suspend fun getAllFilms() = provider.getAllFilms().map { it.toDomain() }
    suspend fun getAllPlanets() = provider.getAllPlanets().map { it.toDomain() }
    suspend fun getAllSpecies() = provider.getAllSpecies().map { it.toDomain() }
    suspend fun getAllStarships() = provider.getAllStarships().map { it.toDomain() }
    suspend fun getAllVehicles() = provider.getAllVehicles().map { it.toDomain() }

    suspend fun searchPeople(people : String) = provider.searchPeople(people).map { it.toDomain() }
    suspend fun searchFilm(film : String) = provider.searchFilm(film).map { it.toDomain() }
    suspend fun searchPlanet(planet : String) = provider.searchPlanet(planet).map { it.toDomain() }
    suspend fun searchSpecie(specie : String) = provider.searchSpecie(specie).map { it.toDomain() }
    suspend fun searchStarship(starship : String) = provider.searchStarship(starship).map { it.toDomain() }
    suspend fun searchVehicle(vehicle : String) = provider.searchVehicle(vehicle).map { it.toDomain() }
}