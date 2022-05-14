package com.client.aircasting.ui.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.ui.viewmodel.AuthViewModel
import com.client.aircasting.ui.view.navigation.nav_graphs.authNavGraph
import com.client.aircasting.ui.view.navigation.nav_graphs.homeNavGraph
import com.client.aircasting.ui.view.navigation.nav_graphs.introNavGraph

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        introNavGraph(navController)
        authNavGraph(navController)
        homeNavGraph(navController)
    }
}