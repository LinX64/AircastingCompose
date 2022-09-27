package com.client.aircasting.ui.view.main.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.client.aircasting.ui.view.lets_begin.LetsBegin
import com.client.aircasting.ui.view.settings.Settings

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Dashboard(navController)
        }
        composable(NavigationItem.LetsBegin.route) {
            LetsBegin()
        }
        composable(NavigationItem.Settings.route) {
            Settings()
        }
    }
}