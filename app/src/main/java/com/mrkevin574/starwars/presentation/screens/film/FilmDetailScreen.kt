package com.mrkevin574.starwars.presentation.screens.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.domain.model.Film
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
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
fun FilmDetailScreen(film : Film)
{
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center
    ){
        item {
            Text(
                text = film.title,
                color = YellowStarWars,
                fontFamily = starWarsFont,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )
            Text(
                text = film.opening_crawl,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                textAlign = TextAlign.Center,
                fontFamily = starWarsFont
            )
            ComponentDetail(type = stringResource(R.string.director), value = film.director)
            ComponentDetail(type = stringResource(R.string.producer), value = film.producer)
            ComponentDetail(type = stringResource(R.string.release), value = film.release_date)
            ComponentDetail(
                type = stringResource(R.string.characters),
                value = film.characters.size.toString()
            )
            ComponentDetail(
                type = stringResource(R.string.planets),
                value = film.planets.size.toString()
            )
            ComponentDetail(
                type = stringResource(R.string.starships),
                value = film.starships.size.toString()
            )
            ComponentDetail(
                type = stringResource(R.string.species),
                value = film.species.size.toString()
            )
            ComponentDetail(
                type = stringResource(R.string.characters),
                value = film.characters.size.toString()
            )
            ComponentDetail(
                type = stringResource(R.string.vehicles),
                value = film.vehicles.size.toString()
            )
        }
    }

}

@Composable
fun ComponentDetail(type : String, value : String)
{
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "$type: ",
            color = YellowStarWars,
            fontFamily = starWarsFont,
            fontSize = 10.sp
        )
        Text(
            text = value,
            color = Color.Red,
            fontFamily = starWarsFont,
            fontSize = 10.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFilmDetailScreen()
{
    FilmDetailScreen(film = testFilm)
}