package com.client.aircasting.ui.view.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.client.aircasting.ui.view.navigation.NavRoutes
import com.client.aircasting.ui.view.navigation.SEARCH_FIXED_SESSIONS_ROUTE
import com.client.aircasting.ui.view.search.SearchResult
import com.client.aircasting.ui.view.search.SearchSessions

fun NavGraphBuilder.searchFollowGraph() {
    navigation(
        startDestination = NavRoutes.SearchFollow.route,
        route = SEARCH_FIXED_SESSIONS_ROUTE
    ) {
        composable(route = NavRoutes.SearchFollow.route) {
            SearchSessions()
        }
        composable(route = NavRoutes.SearchFollowResult.route) {
            SearchResult()
        }
    }
}