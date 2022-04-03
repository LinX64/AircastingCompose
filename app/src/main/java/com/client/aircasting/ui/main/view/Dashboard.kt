package com.client.aircasting.ui.main.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.client.aircasting.ui.navigation.TabItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun Dashboard() {
    val tabs = listOf(
        TabItem.Following,
        TabItem.Active,
        TabItem.Dormant,
        TabItem.Fixed
    )
    val pagerState = rememberPagerState()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() }, content = {
            Column {
                Tabs(tabs = tabs, pagerState = pagerState)
                TabsContent(tabs = tabs, pagerState = pagerState)
            }
        })
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Dashboard()
}