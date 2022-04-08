package com.client.aircasting.ui.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.client.aircasting.ui.main.view.componenets.ComposeNavigation
import com.client.aircasting.ui.main.view.componenets.TabsContent
import com.client.aircasting.ui.navigation.TabItem
import com.client.aircasting.ui.theme.AircastingTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AircastingTheme {
                Surface {
                    ComposeNavigation()
                }
            }
        }
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


