package com.mrkevin574.starwars.domain

import com.mrkevin574.starwars.data.repository.StarWarsProvider
import com.mrkevin574.starwars.data.repository.model.toDomain
import com.mrkevin574.starwars.domain.model.*
import com.mrkevin574.starwars.util.Resource
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val provider: StarWarsProvider
) {
    suspend fun getAllPeoples() : Resource<List<People>> {
        val response = provider.getAllPeoples()

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error getting people, check your internet connection")
        }
        
        val result = response.body()!!
            .peoples
            .map { 
                it.toDomain()
            }
        return Resource.Success(result)
    }
    suspend fun getAllFilms() : Resource<List<Film>> {
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
    }

    suspend fun getAllPlanets() : Resource<List<Planet>>{
        val response = provider.getAllPlanets()

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error getting planets, check your internet connection")
        }

        val result = response.body()!!
            .planets
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }

    suspend fun getAllSpecies() : Resource<List<Specie>> {
        val response = provider.getAllSpecies()

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error getting species, check your internet connection")
        }

        val result = response.body()!!
            .species
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }
    suspend fun getAllStarships() : Resource<List<Starship>>{
        val response = provider.getAllStarships()

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error getting starships, check your internet connection")
        }

        val result = response.body()!!
            .starships
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }


    suspend fun getAllVehicles() : Resource<List<Vehicle>> {

        val response = provider.getAllVehicles()

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error getting vehicles, check your internet connection")
        }

        val result = response.body()!!
            .vehicles
            .map {
                it.toDomain()
            }
        return Resource.Success(result)

    }

    suspend fun searchPeople(people : String) : Resource<List<People>> {
        val response = provider.searchPeople(people)

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error from server")
        }else if(response.body()!!.peoples.isEmpty()){
            return Resource.Error("$people not found")
        }

        val result = response.body()!!
            .peoples
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }
    suspend fun searchFilm(film : String) : Resource<List<Film>> {
        val response = provider.searchFilm(film)

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error from server")
        }else if(response.body()!!.films.isEmpty()){
            return Resource.Error("$film not found")
        }

        val result = response.body()!!
            .films
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }
    suspend fun searchPlanet(planet : String) : Resource<List<Planet>> {
        val response = provider.searchPlanet(planet)

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error from server")
        }else if(response.body()!!.planets.isEmpty()){
            return Resource.Error("$planet not found")
        }

        val result = response.body()!!
            .planets
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }

    suspend fun searchSpecie(specie : String) : Resource<List<Specie>>{
        val response = provider.searchSpecie(specie)

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error from server")
        }else if(response.body()!!.species.isEmpty()){
            return Resource.Error("$specie not found")
        }

        val result = response.body()!!
            .species
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }
    suspend fun searchStarship(starship : String) : Resource<List<Starship>> {
        val response = provider.searchStarship(starship)

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error from server")
        }else if(response.body()!!.starships.isEmpty()){
            return Resource.Error("$starship not found")
        }

        val result = response.body()!!
            .starships
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }
    suspend fun searchVehicle(vehicle : String) : Resource<List<Vehicle>> {
        val response = provider.searchVehicle(vehicle)

        if(! (response.isSuccessful) && response.code() != 200)
        {
            return Resource.Error("Error from server")
        }else if(response.body()!!.vehicles.isEmpty()){
            return Resource.Error("$vehicle not found")
        }

        val result = response.body()!!
            .vehicles
            .map {
                it.toDomain()
            }
        return Resource.Success(result)
    }
}