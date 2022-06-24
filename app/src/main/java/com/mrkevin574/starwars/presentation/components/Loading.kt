package com.mrkevin574.starwars.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars

@Composable
fun Loading(paddingValues: PaddingValues)
{
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier.height(100.dp),
            color = YellowStarWars,
            strokeWidth = 10.dp,
        )
    }

}