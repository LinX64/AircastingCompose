package com.client.aircasting.ui.main.view.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
fun FollowingScreen() {
    Column(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp)
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.dashboard_empty_header),
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.aircasting_dark_blue),
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(id = R.string.dashboard_empty_text),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Button(
                onClick = { },
                modifier = Modifier
                    .padding(start = 20.dp, top = 30.dp, end = 20.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = colorResource(id = R.color.aircasting_blue_400)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.record_new_session),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.aircasting_white)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun FollowingScreenPreview() {
    val navController = rememberNavController()
    FollowingScreen()
}

fun goToLetsStart(navController: NavHostController) {
    navController.navigate(NavRoutes.LetsStart.route)
}