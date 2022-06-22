package com.mrkevin574.starwars.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mrkevin574.starwars.presentation.components.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarWarsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
