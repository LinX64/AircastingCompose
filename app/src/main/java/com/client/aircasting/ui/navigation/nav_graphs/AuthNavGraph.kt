package com.client.aircasting.ui.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.client.aircasting.ui.auth.view.login.Login
import com.client.aircasting.ui.auth.view.register.Register
import com.client.aircasting.ui.navigation.AUTH_GRAPH_ROUTE
import com.client.aircasting.ui.navigation.NavRoutes

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = NavRoutes.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = NavRoutes.Login.route) {
            Login(navController = navController)
        }
        composable(route = NavRoutes.Register.route) {
            Register(navController = navController)
        }
    }
}