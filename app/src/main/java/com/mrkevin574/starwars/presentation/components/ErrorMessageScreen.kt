package com.mrkevin574.starwars.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont

@Composable
fun ErrorMessageScreen(message : String)
{
    Text(
        text = message,
        modifier = Modifier
            .fillMaxWidth(),
        fontFamily = starWarsFont,
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        color = YellowStarWars
    )
}