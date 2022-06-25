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
import com.mrkevin574.starwars.domain.model.Vehicle
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@Composable
fun VehiclesDetailScreen(vehicle: Vehicle)
{
    LazyColumn(modifier =
    Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center
    ) {
        item{
            Text(
                text = vehicle.name,
                color = YellowStarWars,
                fontFamily = starWarsFont,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )
            ComponentDetail(type = stringResource(R.string.model), value = vehicle.model)
            ComponentDetail(type = stringResource(R.string.manufacturer), value = vehicle.manufacturer)
            ComponentDetail(type = stringResource(R.string.cost_in_credits), value = vehicle.cost_in_credits)
            ComponentDetail(type = stringResource(R.string.length), value = vehicle.length)
            ComponentDetail(type = stringResource(R.string.max_atmosphering_speed), value = vehicle.max_atmosphering_speed)
            ComponentDetail(type = stringResource(R.string.crew), value = vehicle.crew)
            ComponentDetail(type = stringResource(R.string.passengers), value = vehicle.passengers)
            ComponentDetail(type = stringResource(R.string.cargo_capacity), value = vehicle.cargo_capacity)
            ComponentDetail(type = stringResource(R.string.consumables), value = vehicle.consumables)
            ComponentDetail(type = stringResource(R.string.vehicle_class), value = vehicle.vehicle_class)

            ComponentDetail(type = stringResource(R.string.pilots), value =  vehicle.pilots.size.toString())
            ComponentDetail(type = stringResource(R.string.films), value =  vehicle.films.size.toString())
        }

    }
}