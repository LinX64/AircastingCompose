package com.client.aircasting.ui.view.intro.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.navigation.NavRoutes

@Composable
fun ThirdStep(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.aircasting_white))
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

        LinearProgressIndicator(
            progress = 0.60f,
            modifier = Modifier
                .height(8.dp)
                .padding(start = 34.dp, end = 34.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            color = colorResource(id = R.color.aircasting_blue_400)
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(
                    start = dimensionResource(R.dimen.keyline_8),
                    end = dimensionResource(R.dimen.keyline_8),
                    bottom = dimensionResource(R.dimen.keyline_8)
                ),
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = stringResource(R.string.onboarding_page4_header),
                style = MaterialTheme.typography.h4,
                color = colorResource(id = R.color.aircasting_blue_400)
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

            Text(
                text = stringResource(R.string.onboarding_page4_description),
                style = MaterialTheme.typography.body1.merge(LocalTextStyle.current.copy(lineHeight = 28.sp)),
                color = colorResource(id = R.color.aircasting_grey_700)
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_10)))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { goToRegister(navController) },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.aircasting_blue_400))
            ) {
                Text(
                    text = stringResource(id = R.string.accept_button_onboarding),
                    color = colorResource(id = R.color.aircasting_white),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_1)))

            TextButton(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.learn_more_button_onboarding),
                    color = colorResource(id = R.color.aircasting_blue_400),
                    fontWeight = FontWeight.Bold
                )
            }

        }

    }
}

private fun goToRegister(navController: NavHostController) {
    navController.navigate(NavRoutes.Register.route)
}

@Preview
@Composable
fun ShowThirdSlidePreview() {
    val navController = rememberNavController()
    ThirdStep(navController = navController)
}
