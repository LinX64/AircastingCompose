package com.client.aircasting.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.client.aircasting.R

val Moderate = FontFamily(
    Font(R.font.moderat_trial_bold),
    Font(R.font.moderat_trial_medium),
    Font(R.font.moderat_trial_regular)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Moderate,
        fontWeight = FontWeight.Bold,
    ),
    displayMedium = TextStyle(
        fontFamily = Moderate,
        fontWeight = FontWeight.Normal,
    )
)