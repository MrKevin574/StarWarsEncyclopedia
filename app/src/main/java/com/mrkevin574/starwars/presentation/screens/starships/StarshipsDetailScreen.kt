package com.mrkevin574.starwars.presentation.screens.starships

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
import com.mrkevin574.starwars.domain.model.Starship
import com.mrkevin574.starwars.presentation.screens.film.ComponentDetail
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@Composable
fun StarshipsDetailScreen(starship: Starship)
{
    LazyColumn(modifier =
    Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center
    ) {
        item{
            Text(
                text = starship.name,
                color = YellowStarWars,
                fontFamily = starWarsFont,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )
            ComponentDetail(type = stringResource(R.string.model), value = starship.model)
            ComponentDetail(type = stringResource(R.string.manufacturer), value = starship.manufacturer)
            ComponentDetail(type = stringResource(R.string.cost_in_credits), value = starship.cost_in_credits)
            ComponentDetail(type = stringResource(R.string.length), value = starship.length)
            ComponentDetail(type = stringResource(R.string.max_atmosphering_speed), value = starship.max_atmosphering_speed)
            ComponentDetail(type = stringResource(R.string.crew), value = starship.crew)
            ComponentDetail(type = stringResource(R.string.passengers), value = starship.passengers)
            ComponentDetail(type = stringResource(R.string.cargo_capacity), value = starship.cargo_capacity)
            ComponentDetail(type = stringResource(R.string.consumables), value = starship.consumables)
            ComponentDetail(type = stringResource(R.string.hyperdrive_rating), value = starship.hyperdrive_rating)
            ComponentDetail(type = stringResource(R.string.MGLT), value = starship.MGLT)
            ComponentDetail(type = stringResource(R.string.starship_class), value = starship.starship_class)
            ComponentDetail(type = stringResource(R.string.pilots), value =  starship.pilots.size.toString())
            ComponentDetail(type = stringResource(R.string.films), value =  starship.films.size.toString())
        }

    }
}