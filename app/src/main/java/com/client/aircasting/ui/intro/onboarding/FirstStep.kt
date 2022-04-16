package com.client.aircasting.ui.intro.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun FirstStep(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.aircasting_white))
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        LinearProgressIndicator(
            progress = 0.20f,
            modifier = Modifier
                .height(8.dp)
                .padding(start = 34.dp, end = 34.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            color = colorResource(id = R.color.aircasting_blue_400)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.phone_in_hand),
            "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 34.dp, end = 34.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.onboarding_page2_header),
                style = MaterialTheme.typography.h4,
                color = colorResource(id = R.color.aircasting_blue_400)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.onboarding_page2_description),
                style = MaterialTheme.typography.body1,
                color = colorResource(id = R.color.aircasting_grey_700),
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { goToSecondStep(navController) },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.aircasting_blue_400))
            ) {
                Text(
                    text = stringResource(id = R.string.continue_button_onboarding),
                    color = colorResource(id = R.color.aircasting_white),
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}

fun goToSecondStep(navController: NavHostController) {
    navController.navigate(NavRoutes.SecondStep.route)
}

@Preview
@Composable
fun ShowFirstSlidePreview() {
    val navController = rememberNavController()
    FirstStep(navController = navController)
}
