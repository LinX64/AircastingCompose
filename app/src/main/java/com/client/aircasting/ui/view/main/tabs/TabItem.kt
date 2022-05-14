package com.client.aircasting.ui.view.main.tabs

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object Following : TabItem("Following", { FollowingScreen() })
    object Active : TabItem("Mobile Active", { MobileActiveScreen() })
    object Dormant : TabItem("Mobile Dormant", { MobileDormantScreen() })
    object Fixed : TabItem("Fixed", { FixedScreen() })

}