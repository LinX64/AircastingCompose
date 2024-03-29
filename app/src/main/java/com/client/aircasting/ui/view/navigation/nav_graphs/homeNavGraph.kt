package com.client.aircasting.ui.view.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.client.aircasting.ui.view.main.components.Dashboard
import com.client.aircasting.ui.view.navigation.HOME_GRAPH_ROUTE
import com.client.aircasting.ui.view.navigation.NavRoutes

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        startDestination = NavRoutes.Dashboard.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(route = NavRoutes.Dashboard.route) {
            Dashboard(navController)
        }
    }
}