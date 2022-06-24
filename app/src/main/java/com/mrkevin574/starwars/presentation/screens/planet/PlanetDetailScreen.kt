package com.mrkevin574.starwars.presentation.screens.planet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.domain.model.Planet
import com.mrkevin574.starwars.presentation.screens.film.ComponentDetail
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@Composable
fun PlanetDetailScreen(planet: Planet)
{
    LazyColumn(modifier =
    Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center
    ) {
        item{
            Text(
                text = planet.name,
                color = YellowStarWars,
                fontFamily = starWarsFont,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )
            ComponentDetail(type = stringResource(R.string.rotation_period), value = planet.rotation_period)
            ComponentDetail(type = stringResource(R.string.orbital_period), value = planet.orbital_period)
            ComponentDetail(type = stringResource(R.string.diameter), value = planet.diameter)
            ComponentDetail(type = stringResource(R.string.climate), value = planet.climate)
            ComponentDetail(type = stringResource(R.string.gravity), value = planet.gravity)
            ComponentDetail(type = stringResource(R.string.terrain), value = planet.terrain)
            ComponentDetail(type = stringResource(R.string.surface_water), value = planet.surface_water)
            ComponentDetail(type = stringResource(R.string.population), value = planet.population)
            ComponentDetail(type = stringResource(R.string.residents), value = planet.residents.size.toString())
            ComponentDetail(type = stringResource(R.string.films), value = planet.films.size.toString())
        }

    }
}