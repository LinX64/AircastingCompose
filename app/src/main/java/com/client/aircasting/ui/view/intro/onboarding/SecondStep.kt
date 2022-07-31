package com.client.aircasting.ui.view.intro.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.navigation.NavRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SecondStep(navController: NavHostController) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
        sheetContent = { BottomSheetContent(coroutineScope, bottomSheetScaffoldState) },
        sheetPeekHeight = 0.dp
    ) {
        LayoutContent(navController, coroutineScope, bottomSheetScaffoldState)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun BottomSheetContent(
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    ConstraintLayout {
        val (img, txtTitle, desc, descTwo) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.ic_x),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 20.dp, end = 24.dp)
                .size(24.dp)
                .constrainAs(img) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .clickable { coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.collapse() } },
            colorFilter = ColorFilter.tint(colorResource(id = R.color.aircasting_green))
        )

        Text(
            modifier = Modifier
                .constrainAs(txtTitle) {
                    top.linkTo(img.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 24.dp, top = 10.dp, end = 24.dp),
            text = stringResource(id = R.string.onboarding_bottomsheet_page3_header),
            style = MaterialTheme.typography.h5,
            color = colorResource(id = R.color.aircasting_green),
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp
        )

        val annotatedString = buildAnnotatedString {
            append(stringResource(id = R.string.onboarding_page3_description1_part1))
            append(" ")
            withStyle(
                style = SpanStyle(
                    color = colorResource(id = R.color.aircasting_green),
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(stringResource(id = R.string.onboarding_page3_description1_part2))
            }
            append(" ")
            append(stringResource(id = R.string.onboarding_page3_description1_part3))
        }
        Text(
            modifier = Modifier
                .constrainAs(desc) {
                    top.linkTo(txtTitle.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 24.dp, top = 24.dp, end = 24.dp),
            text = annotatedString,
            style = MaterialTheme.typography.body1,
            color = colorResource(id = R.color.aircasting_grey_700),
            lineHeight = 30.sp
        )

        val annotatedStringDes = buildAnnotatedString {
            append(stringResource(id = R.string.onboarding_page3_description2_part1))
            append(" ")
            withStyle(
                style = SpanStyle(
                    color = colorResource(id = R.color.aircasting_green),
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(stringResource(id = R.string.onboarding_page3_description2_part2))
            }
            append(" ")
            append(stringResource(id = R.string.onboarding_page3_description2_part3))
        }

        Text(
            modifier = Modifier
                .constrainAs(descTwo) {
                    top.linkTo(desc.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 24.dp, top = 24.dp, bottom = 50.dp, end = 24.dp),
            text = annotatedStringDes,
            style = MaterialTheme.typography.body1,
            color = colorResource(id = R.color.aircasting_grey_700),
            lineHeight = 30.sp
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun LayoutContent(
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aircasting_white))
    ) {
        val (linearProgress, image, text, desc, btn, btnLearn) = createRefs()

        LinearProgressIndicator(
            progress = 0.40f,
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
            painter = painterResource(id = R.drawable.airbeam),
            "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 20.dp, end = 24.dp)
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
            text = stringResource(R.string.onboarding_page3_header),
            style = MaterialTheme.typography.h4,
            color = colorResource(id = R.color.aircasting_green),
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
            text = stringResource(R.string.onboarding_page3_description),
            style = MaterialTheme.typography.body1,
            color = colorResource(id = R.color.aircasting_grey_700),
            lineHeight = 30.sp
        )

        Button(
            modifier = Modifier
                .padding(start = 24.dp, top = 24.dp, end = 24.dp)
                .fillMaxWidth()
                .height(50.dp)
                .constrainAs(btn) {
                    top.linkTo(desc.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onClick = { goToThirdStep(navController) },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.aircasting_green))
        ) {
            Text(
                text = stringResource(id = R.string.continue_button_onboarding),
                color = colorResource(id = R.color.aircasting_white),
                fontWeight = FontWeight.Bold
            )
        }

        TextButton(
            modifier = Modifier
                .constrainAs(btnLearn) {
                    top.linkTo(btn.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 24.dp, top = 10.dp, end = 24.dp)
                .fillMaxWidth()
                .height(50.dp), onClick = {
                coroutineScope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) bottomSheetScaffoldState.bottomSheetState.expand()
                    else bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }) {
            Text(
                text = stringResource(id = R.string.learn_more_button_onboarding),
                color = colorResource(id = R.color.aircasting_green),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun goToThirdStep(navController: NavHostController) {
    navController.navigate(NavRoutes.ThirdStep.route)
}

@Preview(device = Devices.PIXEL_2)
@Composable
fun SecondViewPreview() {
    val navController = rememberNavController()
    SecondStep(navController = navController)
}

@Preview(device = Devices.PIXEL_3)
@Composable
fun SecondViewPreviewPixel3() {
    val navController = rememberNavController()
    SecondStep(navController = navController)
}

@Preview(device = Devices.PIXEL_3_XL)
@Composable
fun SecondViewPreviewPixel3xl() {
    val navController = rememberNavController()
    SecondStep(navController = navController)
}