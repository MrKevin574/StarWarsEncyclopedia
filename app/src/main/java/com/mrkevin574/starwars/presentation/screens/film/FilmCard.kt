package com.mrkevin574.starwars.presentation.screens.film

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.domain.model.Film
import com.mrkevin574.starwars.presentation.ui.theme.Black400
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWarsSecondary
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilmCard(
    film: Film,
    onClick : () -> Unit
)
{
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 30.dp,
                bottom = 15.dp
            ),
        border = BorderStroke(3.dp, YellowStarWars),
        elevation = 8.dp,
        content = { ContentCard(film)}
    )
}

@Composable
fun ContentCard(film : Film)
{
    Column(
        modifier = Modifier.background(Black400)
    ) {
        Text(
            text = film.title,
            color = YellowStarWars,
            fontSize = 22.sp,
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center,
            fontFamily = starWarsFont
        )

        Text(
            text = film.opening_crawl,
            color = Color.Gray,
            fontSize = 8.sp,
            modifier = Modifier.fillMaxWidth()
                .padding(18.dp),
            textAlign = TextAlign.Center,
            fontFamily = starWarsFont
        )

        Text(
            text = film.release_date,
            color = YellowStarWarsSecondary,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
                .padding(18.dp),
            textAlign = TextAlign.Center,
            fontFamily = starWarsFont
        )
    }
}
