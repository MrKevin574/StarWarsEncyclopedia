package com.mrkevin574.starwars.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mrkevin574.starwars.ui.theme.StarWarsTheme

@Composable
fun MainScreen()
{
    StarWarsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {

        }
    }
}