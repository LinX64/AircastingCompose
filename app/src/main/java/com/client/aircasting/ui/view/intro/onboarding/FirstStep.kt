package com.client.aircasting.ui.view.intro.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.navigation.NavRoutes

@Composable
fun FirstStep(navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aircasting_white))
    ) {
        val (linearProgress, image, text, desc, btn) = createRefs()

        LinearProgressIndicator(
            progress = 0.20f,
            modifier = Modifier
                .height(8.dp)
                .padding(start = 34.dp, end = 34.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .constrainAs(linearProgress) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            color = colorResource(id = R.color.aircasting_blue_400)
        )

        Image(
            painter = painterResource(id = R.drawable.onboarding_air),
            "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
                .constrainAs(image) {
                    top.linkTo(linearProgress.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Fit
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 24.dp, bottom = 24.dp, end = 34.dp)
                .constrainAs(text) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(R.string.onboarding_page2_header),
            style = MaterialTheme.typography.h4,
            color = colorResource(id = R.color.aircasting_blue_400),
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .constrainAs(desc) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 24.dp, bottom = 24.dp, end = 24.dp),
            text = stringResource(R.string.onboarding_page2_description),
            style = MaterialTheme.typography.body1,
            color = colorResource(id = R.color.aircasting_grey_700),
            lineHeight = 30.sp
        )

        Button(
            modifier = Modifier
                .padding(start = 24.dp, top = 20.dp, end = 24.dp)
                .fillMaxWidth()
                .height(50.dp)
                .constrainAs(btn) {
                    top.linkTo(desc.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
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

fun goToSecondStep(navController: NavHostController) {
    navController.navigate(NavRoutes.SecondStep.route)
}

@Preview
@Composable
fun ShowFirstSlidePreview() {
    val navController = rememberNavController()
    FirstStep(navController = navController)
}
