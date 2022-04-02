package com.client.aircasting.ui.main.view

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object Following : TabItem("FOLLOWING", { FollowingScreen() })
    object Active : TabItem("MOBILE ACTIVE", { MobileActiveScreen() })
    object Dormant : TabItem("MOBILE DORMANT", { MobileDormantScreen() })
    object Fixed : TabItem("FIXED", { FixedScreen() })

}