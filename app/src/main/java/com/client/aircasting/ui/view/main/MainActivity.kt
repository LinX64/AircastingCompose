package com.client.aircasting.ui.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
                SetupNavGraph(mainViewModel)
            }
        }
    }
}


