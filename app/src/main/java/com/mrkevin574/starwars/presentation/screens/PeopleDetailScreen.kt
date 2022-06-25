package com.mrkevin574.starwars.presentation.screens

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
import com.mrkevin574.starwars.domain.model.People
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@Composable
fun PeopleDetailScreen(people: People)
{
    LazyColumn(modifier =
    Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center
    ) {
        item{
            Text(
                text = people.name,
                color = YellowStarWars,
                fontFamily = starWarsFont,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )
            ComponentDetail(type = stringResource(R.string.height), value = people.height)
            ComponentDetail(type = stringResource(R.string.hair_color), value = people.hair_color)
            ComponentDetail(type = stringResource(R.string.skin_color), value = people.skin_color)
            ComponentDetail(type = stringResource(R.string.eye_color), value = people.eye_color)
            ComponentDetail(type = stringResource(R.string.birth_year), value = people.birth_year)
            ComponentDetail(type = stringResource(R.string.gender), value = people.gender)
            ComponentDetail(type = stringResource(R.string.homeworld), value = people.homeworld)
            ComponentDetail(type = stringResource(R.string.films), value = people.films.size.toString())
            ComponentDetail(type = stringResource(R.string.species), value = people.species.size.toString())
            ComponentDetail(type = stringResource(R.string.vehicles), value = people.vehicles.size.toString())
            ComponentDetail(type = stringResource(R.string.starships), value = people.starships.size.toString())
        }

    }
}