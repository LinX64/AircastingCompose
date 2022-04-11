package com.client.aircasting.ui.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.client.aircasting.ui.intro.GetStarted
import com.client.aircasting.ui.intro.slides.FirstSlide
import com.client.aircasting.ui.intro.slides.SecondSlide
import com.client.aircasting.ui.intro.slides.ThirdSlide
import com.client.aircasting.ui.navigation.INTRO_GRAPH_ROUTE
import com.client.aircasting.ui.navigation.NavRoutes

fun NavGraphBuilder.introNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = NavRoutes.GetStarted.route,
        route = INTRO_GRAPH_ROUTE
    ) {
        composable(NavRoutes.GetStarted.route) {
            GetStarted(navController = navController)
        }
        composable(NavRoutes.FirstSlide.route) {
            FirstSlide(navController = navController)
        }
        composable(NavRoutes.SecondSlide.route) {
            SecondSlide(navController = navController)
        }
        composable(NavRoutes.ThirdSlide.route) {
            ThirdSlide(navController = navController)
        }
    }
}