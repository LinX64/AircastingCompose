package com.client.aircasting.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.navigation.NavRoutes

@Composable
fun GetStarted(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aircasting_white))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_picture_1),
                "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_icon_aircasting_small),
                "",
                colorFilter = ColorFilter.tint(color = colorResource(R.color.aircasting_blue_400)),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 60.dp, end = 50.dp)
                    .height(24.dp)
                    .width(24.dp),
            )

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.aircasting_blue_400),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = stringResource(id = R.string.onboarding_page1_description),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.aircasting_grey_700),
                lineHeight = 28.sp
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Column(
            modifier = Modifier
                .padding(start = 32.dp, bottom = 32.dp, end = 32.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { goToDashboard(navController) }) {
                Text(
                    text = stringResource(id = R.string.get_started),
                    color = colorResource(id = R.color.aircasting_blue_400),
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}

fun goToDashboard(navController: NavHostController) {
    navController.navigate(NavRoutes.FirstStep.route)
}

@Preview(showBackground = true)
@Composable
fun ShowGetStartedPreview() {
    val navController = rememberNavController()
    GetStarted(navController = navController)
}
