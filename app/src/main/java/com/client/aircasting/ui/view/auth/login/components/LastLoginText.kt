package com.client.aircasting.ui.view.auth.login.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.navigation.NavRoutes

@Composable
fun LastLoginText(navController: NavHostController) {
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

        /*Text(
            text = stringResource(id = R.string.create_account_text_button),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.keyline_3)),
            color = colorResource(id = R.color.aircasting_blue_400),
            fontWeight = FontWeight.Bold
        )*/

        val annotatedString = buildAnnotatedString {
            append(stringResource(R.string.create_account_text_button))

        }
        ClickableText(
            text = annotatedString,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = dimensionResource(R.dimen.keyline_2)),
            onClick = {
                goToRegister(navController)
            })
    }
}

private fun goToRegister(navController: NavHostController) {
    navController.navigate(NavRoutes.Register.route)
}

@Preview
@Composable
fun ShowLastLoginText() {
    val navController = rememberNavController()
    LastLoginText(navController)
}