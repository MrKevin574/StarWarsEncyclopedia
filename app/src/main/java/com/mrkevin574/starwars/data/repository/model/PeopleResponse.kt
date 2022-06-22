package com.mrkevin574.starwars.data.repository.model

import com.google.gson.annotations.SerializedName
import com.mrkevin574.starwars.domain.model.People

data class PeopleResponseAPI(
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val peoples : List<PeopleResponse>,
)

data class PeopleResponse(
    @SerializedName("name")  val name : String,
    @SerializedName("height")  val height : String,
    @SerializedName("hair_color")  val hair_color : String,
    @SerializedName("skin_color")  val skin_color : String,
    @SerializedName("eye_color")  val eye_color : String,
    @SerializedName("birth_year")  val birth_year : String,
    @SerializedName("gender")  val gender : String,
    @SerializedName("homeworld")  val homeworld : String,
    @SerializedName("films")  val films : List<String>,
    @SerializedName("species")  val species : List<String>,
    @SerializedName("vehicles")  val vehicles : List<String>,
    @SerializedName("starships")  val starships : List<String>,
    @SerializedName("created")  val created : String,
    @SerializedName("edited")  val edited : String,
    @SerializedName("url")  val url : String
)

fun PeopleResponse.toDomain() = People(
    name = this.name,
    height = this.height,
    hair_color = this.hair_color,
    skin_color = this.skin_color,
    eye_color = this.eye_color,
    birth_year = this.birth_year,
    gender = this.gender,
    homeworld = this.homeworld,
    films = this.films,
    species = this.species,
    vehicles = this.vehicles,
    starships = this.starships,
    created = this.created,
    edited = this.edited,
    url = this.url
)
