package com.mrkevin574.starwars.data.repository.model

import com.google.gson.annotations.SerializedName
import com.mrkevin574.starwars.domain.model.Vehicle

data class VehicleResponseAPI(
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val vehicles : List<VehicleResponse>,
)

data class VehicleResponse(
    @SerializedName("name") val name : String,
    @SerializedName("model") val model : String,
    @SerializedName("manufacturer") val manufacturer : String,
    @SerializedName("cost_in_credits") val cost_in_credits : String,
    @SerializedName("length") val length : String,
    @SerializedName("max_atmosphering_speed") val max_atmosphering_speed : String,
    @SerializedName("crew") val crew : String,
    @SerializedName("passengers") val passengers : String,
    @SerializedName("cargo_capacity") val cargo_capacity : String,
    @SerializedName("consumables") val consumables : String,
    @SerializedName("vehicle_class") val vehicle_class : String,
    @SerializedName("pilots") val pilots : List<String>,
    @SerializedName("films") val films : List<String>,
    @SerializedName("created") val created : String,
    @SerializedName("edited") val edited : String,
    @SerializedName("url") val url : String,
)

fun VehicleResponse.toDomain() = Vehicle(
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
    vehicle_class = this.vehicle_class,
    pilots = this.pilots,
    films = this.films,
    created = this.created,
    edited = this.edited,
    url = this.url
)
