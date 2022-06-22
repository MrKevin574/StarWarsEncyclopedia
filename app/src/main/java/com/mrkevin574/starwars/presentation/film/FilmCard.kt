package com.mrkevin574.starwars.presentation.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mrkevin574.starwars.domain.model.Film
import com.mrkevin574.starwars.presentation.ui.theme.Black700

@Composable
fun FilmCard(
    film : Film
)
{
    Text(text = film.title, color = Color.White, modifier = Modifier.background(Black700))
}