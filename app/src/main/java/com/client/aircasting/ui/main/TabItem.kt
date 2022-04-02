package com.client.aircasting.ui.main

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object Following : TabItem("FOLLOWING", { MusicScreen() })
    object Active : TabItem("MOBILE ACTIVE", { MoviesScreen() })
    object Dormant : TabItem("MOBILE DORMANT", { BooksScreen() })
    object Fixed : TabItem("FIXED", { BooksScreen() })

}