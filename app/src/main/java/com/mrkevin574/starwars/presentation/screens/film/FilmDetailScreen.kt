package com.mrkevin574.starwars.presentation.screens.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.domain.model.Film
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@Composable
fun FilmDetailScreen(film : Film)
{
    Text(
        text = film.title,
        color = YellowStarWars,
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),
        fontFamily = starWarsFont,
        fontSize = 28.sp,
        textAlign = TextAlign.Center
    )
}