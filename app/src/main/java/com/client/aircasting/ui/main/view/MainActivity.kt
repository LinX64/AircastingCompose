package com.client.aircasting.ui.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.client.aircasting.ui.navigation.SetupNavGraph
import com.client.aircasting.ui.theme.AircastingTheme
import com.client.aircasting.util.initSize
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSize()

        setContent {
            AircastingTheme {
                SetupNavGraph()
            }
        }

    }
}


