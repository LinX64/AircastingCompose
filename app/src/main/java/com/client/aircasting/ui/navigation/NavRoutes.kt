package com.client.aircasting.ui.navigation

const val INTRO_GRAPH_ROUTE = "intro"
const val ROOT_GRAPH_ROUTE = "root"
const val HOME_GRAPH_ROUTE = "home"
const val AUTH_GRAPH_ROUTE = "auth"

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