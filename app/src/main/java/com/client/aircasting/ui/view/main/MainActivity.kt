package com.client.aircasting.ui.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.ui.view.main.components.Dashboard
import com.client.aircasting.ui.view.navigation.SetupNavGraph
import com.client.aircasting.ui.view.theme.AircastingTheme
import com.client.aircasting.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AircastingTheme {
                SetupNavGraph()
            }
        }
    }
}

@Preview
@Composable
fun ShowMainPreview() {
    val navController = rememberNavController()

    AircastingTheme {
        Dashboard(navController)
    }
}


