package com.mrkevin574.starwars.presentation.planet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.starwars.presentation.StarWarsViewModel

@Composable
fun PlanetScreen(
    viewModel: StarWarsViewModel = hiltViewModel()
)
{
    Text(
        text = "Planets",
        modifier = Modifier.fillMaxSize().background(Color.Black),
        textAlign = TextAlign.Center,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}