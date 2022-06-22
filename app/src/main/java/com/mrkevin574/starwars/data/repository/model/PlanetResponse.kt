package com.mrkevin574.starwars.data.repository.model

import com.google.gson.annotations.SerializedName
import com.mrkevin574.starwars.domain.model.Planet

data class PlanetResponseAPI(
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val planets : List<PlanetResponse>,
)

data class PlanetResponse(
    @SerializedName("name") val name : String,
    @SerializedName("rotation_period") val rotation_period : String,
    @SerializedName("orbital_period") val orbital_period : String,
    @SerializedName("diameter") val diameter : String,
    @SerializedName("climate") val climate : String,
    @SerializedName("gravity") val gravity : String,
    @SerializedName("terrain") val terrain : String,
    @SerializedName("surface_water") val surface_water : String,
    @SerializedName("population") val population : String,
    @SerializedName("residents") val residents : List<String>,
    @SerializedName("films") val films : List<String>,
    @SerializedName("created") val created : String,
    @SerializedName("edited") val edited : String,
    @SerializedName("url") val url : String,
)

fun PlanetResponse.toDomain() = Planet(
    name = this.name,
    rotation_period = this.rotation_period,
    orbital_period = this.orbital_period,
    diameter = this.diameter,
    climate = this.climate,
    gravity = this.gravity,
    terrain = this.terrain,
    surface_water = this.surface_water,
    population = this.population,
    residents = this.residents,
    films = this.films,
    created = this.created,
    edited = this.edited,
    url = this.url
)
