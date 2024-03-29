package com.client.aircasting.ui.view.navigation

const val INTRO_GRAPH_ROUTE = "intro"
const val ROOT_GRAPH_ROUTE = "root"
const val HOME_GRAPH_ROUTE = "home"
const val SEARCH_FIXED_SESSIONS_ROUTE = "searchFollowedSessions"
const val AUTH_GRAPH_ROUTE = "auth"

sealed class NavRoutes(val route: String) {

    //The beginning of the app
    object GetStarted : NavRoutes("get_started")

    //Steps
    object FirstStep : NavRoutes("first_step")
    object SecondStep : NavRoutes("second_step")
    object ThirdStep : NavRoutes("third_step")

    //Auth
    object Login : NavRoutes("login")
    object Register : NavRoutes("register")

    //Dashboard
    object Dashboard : NavRoutes("dashboard")
    object LetsStart : NavRoutes("lets_start")
    object Settings : NavRoutes("settings")

    object SearchFollow : NavRoutes("search_follow")
    object SearchFollowResult : NavRoutes("search_follow_result")
}