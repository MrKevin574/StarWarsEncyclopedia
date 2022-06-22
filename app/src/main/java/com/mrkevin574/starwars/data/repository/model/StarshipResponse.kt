package com.mrkevin574.starwars.data.repository.model

import com.google.gson.annotations.SerializedName
import com.mrkevin574.starwars.domain.model.Starship

data class StarshipResponse(
    @SerializedName("name") val name: String,
    @SerializedName("model") val model: String,
    @SerializedName("manufacturer") val manufacturer: String,
    @SerializedName("cost_in_credits") val cost_in_credits: String,
    @SerializedName("length") val length: String,
    @SerializedName("max_atmosphering_speed") val max_atmosphering_speed: String,
    @SerializedName("crew") val crew: String,
    @SerializedName("passengers") val passengers: String,
    @SerializedName("cargo_capacity") val cargo_capacity: String,
    @SerializedName("consumables") val consumables: String,
    @SerializedName("hyperdrive_rating") val hyperdrive_rating: String,
    @SerializedName("MGLT") val MGLT: String,
    @SerializedName("starship_class") val starship_class: String,
    @SerializedName("pilots") val pilots: List<String>,
    @SerializedName("films") val films: List<String>,
    @SerializedName("created") val created: String,
    @SerializedName("edited") val edited: String,
    @SerializedName("url") val url: String,
)

fun StarshipResponse.toDomain() = Starship(
    name = this.name,
    model = this.model,
    manufacturer = this.manufacturer,
    cost_in_credits = this.cost_in_credits,
    length = this.length,
    max_atmosphering_speed = this.max_atmosphering_speed,
    crew = this.crew,
    passengers = this.passengers,
    cargo_capacity = this.cargo_capacity,
    consumables = this.consumables,
    hyperdrive_rating = this.hyperdrive_rating,
    MGLT = this.MGLT,
    starship_class = this.starship_class,
    pilots = this.pilots,
    films = this.films,
    created = this.created,
    edited = this.edited,
    url = this.url
)
