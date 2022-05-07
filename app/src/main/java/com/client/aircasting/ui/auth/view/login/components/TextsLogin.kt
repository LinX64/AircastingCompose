package com.client.aircasting.ui.auth.view.login.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.client.aircasting.R

@Composable
fun TextsLogin() {
    Text(
        text = stringResource(id = R.string.login_header),
        modifier = Modifier.padding(top = dimensionResource(R.dimen.keyline_10)),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.h5,
        color = colorResource(id = R.color.aircasting_blue_400)
    )

    Text(
        text = stringResource(id = R.string.login_description),
        modifier = Modifier.padding(top = dimensionResource(R.dimen.keyline_5)),
        color = colorResource(id = R.color.aircasting_grey_700)
    )
}