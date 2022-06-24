package com.mrkevin574.starwars.presentation.screens.species

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.domain.model.Specie
import com.mrkevin574.starwars.presentation.ui.theme.Black400
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SpecieCard(
    specie : Specie,
    onClick : () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        border = BorderStroke(5.dp, YellowStarWars),
        elevation = 20.dp,
        content = { ContentPlanetCard(specie) }
    )
}

@Composable
fun ContentPlanetCard(specie: Specie)
{
    Row(
        modifier = Modifier.background(Black400)
    ) {
        Text(
            text = specie.name,
            modifier = Modifier.fillMaxWidth().padding(80.dp),
            textAlign = TextAlign.Center,
            fontFamily = starWarsFont,
            fontSize = 24.sp,
            color = YellowStarWars
        )
    }

}