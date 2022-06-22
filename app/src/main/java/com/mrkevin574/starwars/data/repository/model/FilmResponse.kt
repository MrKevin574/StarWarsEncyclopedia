package com.mrkevin574.starwars.data.repository.model

import com.google.gson.annotations.SerializedName
import com.mrkevin574.starwars.domain.model.Film

data class FilmResponseAPI(
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val films : List<FilmResponse>,
)

data class FilmResponse(
    @SerializedName("title") val title : String,
    @SerializedName("episode_id") val episode_id : Int,
    @SerializedName("opening_crawl") val opening_crawl : String,
    @SerializedName("director") val director : String,
    @SerializedName("producer") val producer : String,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("characters") val characters : List<String>,
    @SerializedName("planets") val planets : List<String>,
    @SerializedName("starships") val starships : List<String>,
    @SerializedName("vehicles") val vehicles : List<String>,
    @SerializedName("species") val species : List<String>,
    @SerializedName("created") val created : String,
    @SerializedName("edited") val edited : String,
    @SerializedName("url") val url : String
)

fun FilmResponse.toDomain() = Film(
    title = this.title,
    episode_id = this.episode_id,
    opening_crawl = this.opening_crawl,
    director = this.director,
    producer = this.producer,
    release_date = this.release_date,
    characters = this.characters,
    planets = this.planets,
    starships = this.starships,
    vehicles = this.vehicles,
    species = this.species,
    created = this.created,
    edited = this.edited,
    url = this.url
)
