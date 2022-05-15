package com.client.aircasting.ui.view.auth.register.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.client.aircasting.R

@Composable
fun RegTextViews() {
    Text(
        text = stringResource(R.string.create_account_header),
        modifier = Modifier.padding(start = 34.dp),
        color = colorResource(id = R.color.aircasting_blue_400),
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

    Text(
        text = stringResource(R.string.create_account_description),
        modifier = Modifier.padding(start = dimensionResource(R.dimen.keyline_9)),
        color = colorResource(id = R.color.aircasting_grey_700),
        style = MaterialTheme.typography.body1,
    )
}