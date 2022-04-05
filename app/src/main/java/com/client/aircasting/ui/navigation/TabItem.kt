package com.client.aircasting.ui.navigation

import androidx.compose.runtime.Composable
import com.client.aircasting.ui.main.view.tabs.FixedScreen
import com.client.aircasting.ui.main.view.tabs.FollowingScreen
import com.client.aircasting.ui.main.view.tabs.MobileActiveScreen
import com.client.aircasting.ui.main.view.tabs.MobileDormantScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object Following : TabItem("Following", { FollowingScreen() })
    object Active : TabItem("Mobile Active", { MobileActiveScreen() })
    object Dormant : TabItem("Mobile Dormant", { MobileDormantScreen() })
    object Fixed : TabItem("Fixed", { FixedScreen() })

}