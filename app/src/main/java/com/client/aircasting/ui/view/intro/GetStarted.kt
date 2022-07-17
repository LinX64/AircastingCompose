package com.client.aircasting.ui.view.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.navigation.NavRoutes

@Composable
fun GetStarted(navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
            .background(colorResource(id = R.color.aircasting_white))
    ) {
        val (imageView, icon, text, txtDesc, btn) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.onboarding_picture_1),
            "",
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(imageView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.FillWidth
        )

        Image(
            painter = painterResource(id = R.drawable.ic_icon_aircasting_small),
            "",
            colorFilter = ColorFilter.tint(color = colorResource(R.color.aircasting_blue_400)),
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(imageView.bottom)
                start.linkTo(text.start)
                end.linkTo(text.absoluteLeft)
                height = Dimension.value(24.dp)
                width = Dimension.value(24.dp)
            }
        )

        Text(
            modifier = Modifier.constrainAs(text) {
                top.linkTo(icon.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.aircasting_blue_400),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.constrainAs(txtDesc) {
                top.linkTo(text.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = stringResource(id = R.string.onboarding_page1_description),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.aircasting_grey_700),
            lineHeight = 28.sp
        )

        OutlinedButton(
            modifier = Modifier
                .constrainAs(btn) {
                    top.linkTo(txtDesc.bottom, margin = 20.dp)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                }
                .height(50.dp)
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            onClick = { goToFirstStep(navController) }) {
            Text(
                text = stringResource(id = R.string.get_started),
                color = colorResource(id = R.color.aircasting_blue_400),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

private fun goToFirstStep(navController: NavHostController) {
    navController.navigate(NavRoutes.FirstStep.route)
}

@Preview(
    name = "Get Started screen",
    showBackground = true,
    showSystemUi = true,
    device = "Pixel 2 XL"
)
@Composable
fun ShowGetStartedPreview() {
    val navController = rememberNavController()
    GetStarted(navController = navController)
}
