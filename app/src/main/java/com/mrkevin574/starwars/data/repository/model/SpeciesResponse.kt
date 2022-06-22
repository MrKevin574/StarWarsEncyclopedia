package com.mrkevin574.starwars.data.repository.model

import com.google.gson.annotations.SerializedName
import com.mrkevin574.starwars.domain.model.Specie

data class SpeciesResponse(
    @SerializedName("name") val name : String,
    @SerializedName("classification") val classification : String,
    @SerializedName("designation") val designation : String,
    @SerializedName("average_height") val average_height : String,
    @SerializedName("skin_colors") val skin_colors : String,
    @SerializedName("hair_colors") val hair_colors : String,
    @SerializedName("eye_colors") val eye_colors : String,
    @SerializedName("average_lifespan") val average_lifespan : String,
    @SerializedName("homeworld") val homeworld : String,
    @SerializedName("language") val language : String,
    @SerializedName("people") val people : List<String>,
    @SerializedName("films") val films : List<String>,
    @SerializedName("created") val created : String,
    @SerializedName("edited") val edited : String,
    @SerializedName("url") val url : String,
)

fun SpeciesResponse.toDomain() = Specie(
    name = this.name,
    classification = this.classification,
    designation = this.designation,
    average_height = this.average_height,
    skin_colors = this.skin_colors,
    hair_colors = this.hair_colors,
    eye_colors = this.eye_colors,
    average_lifespan = this.average_lifespan,
    homeworld = this.homeworld,
    language = this.language,
    people = this.people,
    films = this.films,
    created = this.created,
    edited = this.edited,
    url = this.url,
)
