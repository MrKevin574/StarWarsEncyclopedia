package com.mrkevin574.starwars.presentation.screens.species

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
import com.mrkevin574.starwars.domain.model.Specie
import com.mrkevin574.starwars.presentation.screens.film.ComponentDetail
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@Composable
fun SpeciesDetailScreen(specie: Specie)
{
    LazyColumn(modifier =
    Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center
    ) {
        item{
            Text(
                text = specie.name,
                color = YellowStarWars,
                fontFamily = starWarsFont,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )
            ComponentDetail(type = stringResource(R.string.classification), value = specie.classification)
            ComponentDetail(type = stringResource(R.string.designation), value = specie.designation)
            ComponentDetail(type = stringResource(R.string.average_height), value = specie.average_height)
            ComponentDetail(type = stringResource(R.string.skin_colors), value = specie.skin_colors)
            ComponentDetail(type = stringResource(R.string.hair_colors), value = specie.hair_colors)
            ComponentDetail(type = stringResource(R.string.eye_colors), value = specie.eye_colors)
            ComponentDetail(type = stringResource(R.string.average_lifespan), value = specie.average_lifespan)
            ComponentDetail(type = stringResource(R.string.homeworld), value = specie.homeworld)
            ComponentDetail(type = stringResource(R.string.language), value = specie.language)
            ComponentDetail(type = stringResource(R.string.people), value = specie.people.size.toString())
            ComponentDetail(type = stringResource(R.string.films), value = specie.films.size.toString())
        }

    }
}