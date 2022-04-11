package com.client.aircasting.ui.main.view.componenets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.client.aircasting.R

@Composable
fun TopBar() {
    TopAppBar(
        elevation = 0.dp,
        title = {
            Text(
                modifier = Modifier.padding(start = 5.dp, top = 20.dp, bottom = 5.dp),
                text = stringResource(R.string.title_dashboard),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        },
        backgroundColor = Color.White,
        contentColor = colorResource(id = R.color.aircasting_dark_blue)
    )
}