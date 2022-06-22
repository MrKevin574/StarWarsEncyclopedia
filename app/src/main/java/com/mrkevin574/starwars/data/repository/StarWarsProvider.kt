package com.mrkevin574.starwars.data.repository

import com.mrkevin574.starwars.data.repository.model.*
import com.mrkevin574.starwars.domain.model.People
import com.mrkevin574.starwars.domain.model.Planet
import com.mrkevin574.starwars.util.StarWarsAPI
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsProvider {

    @GET(StarWarsAPI.PEOPLE)
    suspend fun searchPeople(@Query(StarWarsAPI.QUERY) people : String) : PeopleResponseAPI?

    @GET(StarWarsAPI.PEOPLE)
    suspend fun getAllPeoples() :PeopleResponseAPI

    @GET(StarWarsAPI.FILMS)
    suspend fun searchFilm(@Query(StarWarsAPI.QUERY) film : String) : FilmResponseAPI?

    @GET(StarWarsAPI.FILMS)
    suspend fun getAllFilms() : FilmResponseAPI

    @GET(StarWarsAPI.PLANETS)
    suspend fun searchPlanet(@Query(StarWarsAPI.QUERY) planet : String) : PlanetResponseAPI?

    @GET(StarWarsAPI.PLANETS)
    suspend fun getAllPlanets() : PlanetResponseAPI

    @GET(StarWarsAPI.SPECIES)
    suspend fun searchSpecie(@Query(StarWarsAPI.QUERY) specie : String) :SpeciesResponseAPI?

    @GET(StarWarsAPI.SPECIES)
    suspend fun getAllSpecies() : SpeciesResponseAPI

    @GET(StarWarsAPI.STARSHIPS)
    suspend fun searchStarship(@Query(StarWarsAPI.QUERY) starship : String) : StarshipResponseAPI?

    @GET(StarWarsAPI.STARSHIPS)
    suspend fun getAllStarships() : StarshipResponseAPI

    @GET(StarWarsAPI.VEHICLES)
    suspend fun searchVehicle(@Query(StarWarsAPI.QUERY) vehicle : String) : VehicleResponseAPI?

    @GET(StarWarsAPI.VEHICLES)
    suspend fun getAllVehicles() : VehicleResponseAPI

}