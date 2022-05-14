package com.client.aircasting.ui.view.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.client.aircasting.ui.view.auth.login.Login
import com.client.aircasting.ui.view.auth.register.Register
import com.client.aircasting.ui.view.navigation.AUTH_GRAPH_ROUTE
import com.client.aircasting.ui.view.navigation.NavRoutes

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {

    navigation(
        startDestination = NavRoutes.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(NavRoutes.Login.route) {
            Login(navController = navController)
        }
        composable(NavRoutes.Register.route) {
            Register(navController = navController)
        }
    }
}