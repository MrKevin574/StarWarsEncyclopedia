package com.mrkevin574.starwars.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.presentation.ui.theme.Black700
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWars
import com.mrkevin574.starwars.presentation.ui.theme.YellowStarWarsSecondary
import com.mrkevin574.starwars.presentation.ui.theme.starWarsFont


@Composable
fun OptionSearch(label : String, onSearch: (String) -> Unit)
{
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onSearch(text)
        },
        label = { Text(
            label, fontFamily =
            starWarsFont,
            color = YellowStarWarsSecondary) },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Black700),
        textStyle = TextStyle(
            color = YellowStarWars,
            fontFamily = starWarsFont,
            fontSize = 18.sp
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = YellowStarWars,
            unfocusedBorderColor = YellowStarWarsSecondary
        )
    )
}