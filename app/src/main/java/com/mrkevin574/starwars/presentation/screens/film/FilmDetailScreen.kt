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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.R
import com.mrkevin574.starwars.domain.model.Film
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

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
fun ComponentDetail(type : String, value : String?)
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
            text = value ?: stringResource(R.string.not_available),
            color = Color.Red,
            fontFamily = starWarsFont,
            fontSize = 10.sp
        )
    }
}
