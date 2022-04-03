package com.client.aircasting.ui.navigation

sealed class NavRoutes(val route: String) {
    //The beginning of the app
    object GetStarted : NavRoutes("get_started")

    //Slides
    object FirstSlide : NavRoutes("first_slide")
    object SecondSlide : NavRoutes("second_slide")
    object ThirdSlide : NavRoutes("third_slide")

    //Auth
    object Login : NavRoutes("login")
    object Register : NavRoutes("register")

    //Dashboard
    object Dashboard : NavRoutes("dashboard")
    object LetsStart : NavRoutes("lets_start")
    object Settings : NavRoutes("settings")
}