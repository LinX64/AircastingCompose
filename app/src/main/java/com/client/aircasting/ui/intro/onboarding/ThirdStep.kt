package com.client.aircasting.ui.intro.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ThirdStep(navController: NavController) {


}

@Preview
@Composable
fun ShowThirdSlidePreview() {
    val navController = rememberNavController()
    ThirdStep(navController = navController)
}
