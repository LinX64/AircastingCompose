package com.client.aircasting.ui.view.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.main.tabs.TabItem
import com.client.aircasting.ui.view.theme.AircastingTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Dashboard(navController: NavHostController) {
    val tabs = listOf(
        TabItem.Following,
        TabItem.Active,
        TabItem.Dormant,
        TabItem.Fixed
    )
    val pagerState = rememberPagerState()

    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomNavigationBar(navController) },
        content = {

            Column {
                Tabs(tabs = tabs, pagerState = pagerState)
                TabsContent(tabs = tabs, pagerState = pagerState)
            }
        })
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 5.dp,
        containerColor = colorResource(id = R.color.aircasting_white),
        contentColor = colorResource(id = R.color.aircasting_grey_700)
    ) {

        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                })
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    AircastingTheme {
        Dashboard(navController)
    }
}