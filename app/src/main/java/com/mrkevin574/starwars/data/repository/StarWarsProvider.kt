package com.mrkevin574.starwars.data.repository

import com.mrkevin574.starwars.data.repository.model.*
import com.mrkevin574.starwars.domain.model.People
import com.mrkevin574.starwars.domain.model.Planet
import com.mrkevin574.starwars.util.StarWarsAPI
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsProvider {

    @GET("${StarWarsAPI.SEARCH_PEOPLE}{people}")
    suspend fun searchPeople(@Path("people") people : String) : PeopleResponseAPI

    @GET("${StarWarsAPI.SEARCH_FILM}{film}")
    suspend fun searchFilm(@Path("film") film : String) : FilmResponseAPI

    @GET("${StarWarsAPI.SEARCH_PLANET}{planet}")
    suspend fun searchPlanet(@Path("planet") planet : String) : PlanetResponseAPI

    @GET("${StarWarsAPI.SEARCH_SPECIE}{specie}")
    suspend fun searchSpecie(@Path("specie") specie : String) :SpeciesResponseAPI

    @GET("${StarWarsAPI.SEARCH_STARSHIP}{starship}")
    suspend fun searchStarship(@Path("starship") starship : String) : StarshipResponseAPI

    @GET("${StarWarsAPI.SEARCH_VEHICLE}{vehicle}")
    suspend fun searchVehicle(@Path("vehicle") vehicle : String) : VehicleResponseAPI

    @GET(StarWarsAPI.PEOPLE)
    suspend fun getAllPeoples() :PeopleResponseAPI

    @GET(StarWarsAPI.FILMS)
    suspend fun getAllFilms() : FilmResponseAPI

    @GET(StarWarsAPI.PLANETS)
    suspend fun getAllPlanets() : PlanetResponseAPI

    @GET(StarWarsAPI.SPECIES)
    suspend fun getAllSpecies() : SpeciesResponseAPI

    @GET(StarWarsAPI.STARSHIPS)
    suspend fun getAllStarships() : StarshipResponseAPI

    @GET(StarWarsAPI.VEHICLES)
    suspend fun getAllVehicles() : VehicleResponseAPI

}