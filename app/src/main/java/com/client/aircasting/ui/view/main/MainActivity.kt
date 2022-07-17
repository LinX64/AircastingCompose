package com.client.aircasting.ui.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.client.aircasting.ui.view.navigation.SetupNavGraph
import com.client.aircasting.ui.view.theme.AircastingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AircastingTheme {
                SetupNavGraph()
            }
        }
    }
}


