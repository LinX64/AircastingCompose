package com.client.aircasting.ui.view.lets_begin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LetsBegin() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Lets begin Screen", style = MaterialTheme.typography.h5)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLetsBegin() {
    LetsBegin()
}