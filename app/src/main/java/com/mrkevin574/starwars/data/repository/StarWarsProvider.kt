package com.mrkevin574.starwars.data.repository

import com.mrkevin574.starwars.data.repository.model.*
import com.mrkevin574.starwars.util.StarWarsAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsProvider {

    @GET(StarWarsAPI.PEOPLE)
    suspend fun searchPeople(@Query(StarWarsAPI.QUERY) people : String) : Response<PeopleResponseAPI>

    @GET(StarWarsAPI.PEOPLE)
    suspend fun getAllPeoples() : Response<PeopleResponseAPI>

    @GET(StarWarsAPI.FILMS)
    suspend fun searchFilm(@Query(StarWarsAPI.QUERY) film : String) : Response<FilmResponseAPI>

    @GET(StarWarsAPI.FILMS)
    suspend fun getAllFilms() : Response<FilmResponseAPI>

    @GET(StarWarsAPI.PLANETS)
    suspend fun searchPlanet(@Query(StarWarsAPI.QUERY) planet : String) : Response<PlanetResponseAPI>

    @GET(StarWarsAPI.PLANETS)
    suspend fun getAllPlanets() : Response<PlanetResponseAPI>

    @GET(StarWarsAPI.SPECIES)
    suspend fun searchSpecie(@Query(StarWarsAPI.QUERY) specie : String) : Response<SpeciesResponseAPI>

    @GET(StarWarsAPI.SPECIES)
    suspend fun getAllSpecies() : Response<SpeciesResponseAPI>

    @GET(StarWarsAPI.STARSHIPS)
    suspend fun searchStarship(@Query(StarWarsAPI.QUERY) starship : String) : Response<StarshipResponseAPI>

    @GET(StarWarsAPI.STARSHIPS)
    suspend fun getAllStarships() : Response<StarshipResponseAPI>

    @GET(StarWarsAPI.VEHICLES)
    suspend fun searchVehicle(@Query(StarWarsAPI.QUERY) vehicle : String) : Response<VehicleResponseAPI>

    @GET(StarWarsAPI.VEHICLES)
    suspend fun getAllVehicles() : Response<VehicleResponseAPI>

}