package com.client.aircasting.ui.view.auth.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.client.aircasting.R

@Composable
fun BoxText() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.keyline_5)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = stringResource(id = R.string.forgot_your_password),
            color = colorResource(
                id = R.color.aircasting_blue_400
            ), style = MaterialTheme.typography.body1
        )
    }
}