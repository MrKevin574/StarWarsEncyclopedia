package com.mrkevin574.starwars.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mrkevin574.starwars.R

val starWarsFont = FontFamily(
    Font(R.font.starjedi)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = starWarsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

)

