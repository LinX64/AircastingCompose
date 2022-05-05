package com.client.aircasting.ui.auth.view.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.navigation.NavRoutes

@Composable
fun Register(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_10)))

        LinearProgressIndicator(
            progress = 0.90f,
            modifier = Modifier
                .height(dimensionResource(R.dimen.keyline_2))
                .padding(
                    start = dimensionResource(R.dimen.keyline_8),
                    end = dimensionResource(R.dimen.keyline_8)
                )
                .clip(RoundedCornerShape(dimensionResource(R.dimen.keyline_5)))
                .fillMaxWidth(),
            color = colorResource(R.color.aircasting_blue_400)
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_10)))

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
}

private fun goToLogin(navController: NavController) {
    navController.navigate(NavRoutes.Login.route)
}

@Preview
@Composable
fun ShowRegisterPreview() {
    val navController = rememberNavController()
    Register(navController = navController)
}
