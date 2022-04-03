package com.client.aircasting.ui.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.intro.GetStarted
import com.client.aircasting.ui.navigation.NavRoutes
import com.client.aircasting.ui.navigation.TabItem
import com.client.aircasting.ui.theme.AircastingComposeTheme
import com.google.accompanist.pager.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AircastingComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ComposeNavigation()
                }
            }
        }
    }
}

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.GetStarted.route,
    ) {
        composable(NavRoutes.GetStarted.route) {
            GetStarted(navController = navController)
        }
        composable(NavRoutes.Dashboard.route) {
            Dashboard()
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        elevation = 0.dp,
        title = {
            Text(
                modifier = Modifier.padding(start = 10.dp, top = 20.dp, bottom = 10.dp),
                text = stringResource(R.string.title_dashboard),
                fontSize = 20.sp
            )
        },
        backgroundColor = Color.White,
        contentColor = colorResource(id = R.color.aircasting_dark_blue)
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(backgroundColor = Color.White) {

        BottomNavigationItem(icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_black_24dp),
                ""
            )
        }, selectedContentColor = colorResource(id = R.color.aircasting_blue_400),
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_plus_black_24), "")
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings_black_24dp),
                ""
            )
        },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = colorResource(id = R.color.aircasting_blue_400),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {

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

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    val tabs = listOf(
        TabItem.Following,
        TabItem.Active,
        TabItem.Dormant,
        TabItem.Fixed
    )
    val pagerState = rememberPagerState()
    Tabs(tabs = tabs, pagerState = pagerState)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        TabItem.Following,
        TabItem.Active,
        TabItem.Dormant,
        TabItem.Fixed
    )
    val pagerState = rememberPagerState()
    TabsContent(tabs = tabs, pagerState = pagerState)
}

