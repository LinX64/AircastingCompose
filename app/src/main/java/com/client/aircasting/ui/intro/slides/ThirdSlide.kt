package com.client.aircasting.ui.intro.slides

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.ui.auth.view.register.Register

@Composable
fun ThirdSlide(navController: NavController) {




}

@Preview
@Composable
fun ShowThirdSlidePreview() {
    val navController = rememberNavController()
    Register(navController = navController)
}
