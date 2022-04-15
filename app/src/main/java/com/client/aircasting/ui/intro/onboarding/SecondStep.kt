package com.client.aircasting.ui.intro.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.navigation.NavRoutes

@Composable
fun SecondStep(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aircasting_white))
    ) {

        Image(
            painter = painterResource(id = R.drawable.airbeam_in_hand),
            "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 30.dp),
            contentScale = ContentScale.None
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 34.dp, end = 34.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.onboarding_page3_header),
                style = MaterialTheme.typography.h4,
                color = colorResource(id = R.color.aircasting_green)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(R.string.onboarding_page3_description),
                style = MaterialTheme.typography.body1,
                color = colorResource(id = R.color.aircasting_grey_700),
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { goToThirdStep(navController) },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.aircasting_green))
            ) {
                Text(
                    text = stringResource(id = R.string.continue_button_onboarding),
                    color = colorResource(id = R.color.aircasting_white),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { //TODO
                }
            ) {
                Text(
                    text = stringResource(id = R.string.learn_more_button_onboarding),
                    color = colorResource(id = R.color.aircasting_green),
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

fun goToThirdStep(navController: NavHostController) {
    navController.navigate(NavRoutes.ThirdStep.route)
}

@Preview
@Composable
fun ShowSecondSlidePreview() {
    val navController = rememberNavController()
    SecondStep(navController = navController)
}
