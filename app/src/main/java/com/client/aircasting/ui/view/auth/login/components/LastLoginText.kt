package com.client.aircasting.ui.view.auth.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.client.aircasting.R

@Composable
fun LastLoginText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.keyline_5))
    ) {

        Text(
            text = stringResource(id = R.string.create_account_prompt),
            style = MaterialTheme.typography.body1,
            color = colorResource(id = R.color.aircasting_grey_700)
        )

        Text(
            text = stringResource(id = R.string.create_account_text_button),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.keyline_3)),
            color = colorResource(id = R.color.aircasting_blue_400),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun ShowLastLoginText() {
    LastLoginText()
}