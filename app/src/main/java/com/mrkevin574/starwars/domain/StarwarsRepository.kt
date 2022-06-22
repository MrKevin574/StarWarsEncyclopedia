package com.mrkevin574.starwars.domain

import com.mrkevin574.starwars.data.repository.StarWarsProvider
import com.mrkevin574.starwars.data.repository.model.toDomain
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val provider: StarWarsProvider
) {
    suspend fun getAllPeoples() = provider.getAllPeoples().peoples.map { it.toDomain() }
    suspend fun getAllFilms() = provider.getAllFilms().films.map { it.toDomain() }
    suspend fun getAllPlanets() = provider.getAllPlanets().planets.map { it.toDomain() }
    suspend fun getAllSpecies() = provider.getAllSpecies().species.map { it.toDomain() }
    suspend fun getAllStarships() = provider.getAllStarships().starships.map { it.toDomain() }
    suspend fun getAllVehicles() = provider.getAllVehicles().vehicles.map { it.toDomain() }

    suspend fun searchPeople(people : String) = provider.searchPeople(people)?.peoples?.map { it.toDomain() } ?: emptyList()
    suspend fun searchFilm(film : String) = provider.searchFilm(film)?.films?.map { it.toDomain() } ?: emptyList()
    suspend fun searchPlanet(planet : String) = provider.searchPlanet(planet)?.planets?.map { it.toDomain() } ?: emptyList()
    suspend fun searchSpecie(specie : String) = provider.searchSpecie(specie)?.species?.map { it.toDomain() } ?: emptyList()
    suspend fun searchStarship(starship : String) = provider.searchStarship(starship)?.starships?.map { it.toDomain() } ?: emptyList()
    suspend fun searchVehicle(vehicle : String) = provider.searchVehicle(vehicle)?.vehicles?.map { it.toDomain() } ?: emptyList()
}