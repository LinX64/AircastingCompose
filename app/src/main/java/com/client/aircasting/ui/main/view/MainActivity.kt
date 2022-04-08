package com.client.aircasting.ui.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.client.aircasting.ui.navigation.SetupNavGraph
import com.client.aircasting.ui.theme.AircastingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AircastingTheme {
                Surface {
                    SetupNavGraph()
                }
            }
        }
    }
}




