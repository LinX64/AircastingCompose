package com.client.aircasting.ui.view.intro.onboarding

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
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
fun ThirdStep(navController: NavHostController) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
        sheetContent = { SheetContent(coroutineScope, bottomSheetScaffoldState) },
        sheetPeekHeight = 0.dp
    ) {
        ThirdStepContent(navController, coroutineScope, bottomSheetScaffoldState)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ThirdStepContent(
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.aircasting_white))
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

            androidx.compose.material3.Text(
                text = stringResource(R.string.onboarding_page4_header),
                style = MaterialTheme.typography.h4,
                color = colorResource(id = R.color.aircasting_blue_400)
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

            androidx.compose.material3.Text(
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
                androidx.compose.material3.Text(
                    text = stringResource(id = R.string.accept_button_onboarding),
                    color = colorResource(id = R.color.aircasting_white),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_1)))

            TextButton(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) bottomSheetScaffoldState.bottomSheetState.expand()
                        else bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }) {
                androidx.compose.material3.Text(
                    text = stringResource(id = R.string.learn_more_button_onboarding),
                    color = colorResource(id = R.color.aircasting_blue_400),
                    fontWeight = FontWeight.Bold
                )
            }

        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SheetContent(
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    val scroll = rememberScrollState(0)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aircasting_white))
    ) {
        val (icon, text, desc) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.ic_x),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 20.dp, end = 24.dp)
                .size(24.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .clickable { coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.collapse() } },
            colorFilter = ColorFilter.tint(colorResource(id = R.color.aircasting_blue_400))
        )

        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(text) {
                    top.linkTo(icon.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 24.dp, top = 10.dp, end = 24.dp),
            text = stringResource(id = R.string.onboarding_bottomsheet_page4_header),
            style = MaterialTheme.typography.h5,
            color = colorResource(id = R.color.aircasting_blue_400),
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .padding(top = 20.dp)
                .constrainAs(desc) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 24.dp, top = 10.dp, end = 24.dp)
                .verticalScroll(scroll),
            text = spannableTextView(),
            style = MaterialTheme.typography.body1,
            color = colorResource(id = R.color.aircasting_grey_700),
            lineHeight = 28.sp
        )
    }
}

@Composable
private fun spannableTextView(): AnnotatedString {
    val annotatedString = buildAnnotatedString {
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_header))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_1))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_1))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_2))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_2))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_3))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_3))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_4))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_4))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_5))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_5))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_6))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_6))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_7))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_7))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_8))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_8))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_9))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_9))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_10))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_10))
        append("\n\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_paragraph_11))
        append("\n")
        append(stringResource(R.string.onboarding_bottomsheet_page4_description_11))
        append("\n\n")

    }
    return annotatedString
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

@Preview(device = Devices.PIXEL_3_XL)
@Composable
fun ShowThirdSlidePreviewPixel() {
    val navController = rememberNavController()
    ThirdStep(navController = navController)
}
