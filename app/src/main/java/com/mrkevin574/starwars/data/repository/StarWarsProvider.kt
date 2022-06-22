package com.mrkevin574.starwars.data.repository

import com.mrkevin574.starwars.data.repository.model.*
import com.mrkevin574.starwars.domain.model.People
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsProvider {

    @GET("people/?search={people}")
    suspend fun searchPeople(@Path("people") people : String) : List<PeopleResponse>

    @GET("people/")
    suspend fun getAllPeoples() : List<PeopleResponse>

    @GET("films/")
    suspend fun getAllFilms() : List<FilmResponse>

    @GET("planets/")
    suspend fun getAllPlanets() : List<PlanetResponse>

    @GET("species/")
    suspend fun getAllSpecies() : List<SpeciesResponse>

    @GET("starships/")
    suspend fun getAllStarships() : List<StarshipResponse>

    @GET("vehicles/")
    suspend fun getAllVehicles() : List<VehicleResponse>

}