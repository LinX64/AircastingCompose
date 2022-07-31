package com.client.aircasting.ui.view.main.components

import com.client.aircasting.R

sealed class NavigationItem(var route: String, var icon: Int) {
    object Home : NavigationItem("home", R.drawable.ic_home_black_24dp)
    object LetsBegin : NavigationItem("music", R.drawable.ic_plus_black_24)
    object Settings : NavigationItem("profile", R.drawable.ic_settings_black_24dp)
}