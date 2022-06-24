package com.mrkevin574.starwars.presentation.screens.film

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
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

val testFilm = Film(
    title = "A New Hope",
    episode_id = 4,
    opening_crawl = "It is a period of civil war.\n\nRebel spaceships, striking\n\nfrom a hidden base, have won\n\ntheir first victory against\n\nthe evil Galactic Empire.\n\n\n\nDuring the battle, Rebel\n\nspies managed to steal secret\r\nplans to the Empire's\n\nultimate weapon, the DEATH\n\nSTAR, an armored space\n\nstation with enough power\n\nto destroy an entire planet.\n\n\n\nPursued by the Empire's\n\nsinister agents, Princess\n\nLeia races home aboard her\n\nstarship, custodian of the\n\nstolen plans that can save her\n\npeople and restore\n\nfreedom to the galaxy....",
    director = "George Lucas",
    producer = "Gary Kurtz, Rick McCallum",
    release_date = "1977-05-25",
    characters = listOf("https://swapi.dev/api/people/1/"),
    planets = listOf("https://swapi.dev/api/planets/1/"),
    starships = listOf("https://swapi.dev/api/starships/2/"),
    vehicles = listOf("https://swapi.dev/api/vehicles/4/"),
    species = listOf("https://swapi.dev/api/species/1/"),
    created = "2014-12-10T14:23:31.880000Z",
    edited = "2014-12-12T11:24:39.858000Z",
    url = "https://swapi.dev/api/films/1/"
)

@Composable
fun FilmCard(
    film: Film
)
{
    Card(
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

@Preview(showBackground = true)
@Composable
fun PreviewFilmCard()
{
    FilmCard(film = testFilm)
}