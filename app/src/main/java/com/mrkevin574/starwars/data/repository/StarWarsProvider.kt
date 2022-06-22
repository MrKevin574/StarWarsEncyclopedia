package com.mrkevin574.starwars.data.repository

import com.mrkevin574.starwars.data.repository.model.*
import com.mrkevin574.starwars.domain.model.People
import com.mrkevin574.starwars.util.StarWarsAPI
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsProvider {

    @GET("${StarWarsAPI.SEARCH_PEOPLE}{people}")
    suspend fun searchPeople(@Path("people") people : String) : List<PeopleResponse>

    @GET(StarWarsAPI.PEOPLE)
    suspend fun getAllPeoples() : List<PeopleResponse>

    @GET(StarWarsAPI.FILMS)
    suspend fun getAllFilms() : List<FilmResponse>

    @GET(StarWarsAPI.PLANETS)
    suspend fun getAllPlanets() : List<PlanetResponse>

    @GET(StarWarsAPI.SPECIES)
    suspend fun getAllSpecies() : List<SpeciesResponse>

    @GET(StarWarsAPI.STARSHIPS)
    suspend fun getAllStarships() : List<StarshipResponse>

    @GET(StarWarsAPI.VEHICLES)
    suspend fun getAllVehicles() : List<VehicleResponse>

}