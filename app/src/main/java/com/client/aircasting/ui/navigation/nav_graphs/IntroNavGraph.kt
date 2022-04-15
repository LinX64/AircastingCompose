package com.client.aircasting.ui.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.client.aircasting.ui.intro.GetStarted
import com.client.aircasting.ui.intro.onboarding.FirstStep
import com.client.aircasting.ui.intro.onboarding.SecondStep
import com.client.aircasting.ui.intro.onboarding.ThirdStep
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
        composable(NavRoutes.FirstStep.route) {
            FirstStep(navController = navController)
        }
        composable(NavRoutes.SecondStep.route) {
            SecondStep(navController = navController)
        }
        composable(NavRoutes.ThirdStep.route) {
            ThirdStep(navController = navController)
        }
    }
}