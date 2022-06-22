package com.mrkevin574.starwars.domain.model

import com.google.gson.annotations.SerializedName

data class Specie(
    val name : String,
    val classification : String,
    val designation : String,
    val average_height : String,
    val skin_colors : String,
    val hair_colors : String,
    val eye_colors : String,
    val average_lifespan : String,
    val homeworld : String,
    val language : String,
    val people : List<String>,
    val films : List<String>,
    val created : String,
    val edited : String,
    val url : String,
)
