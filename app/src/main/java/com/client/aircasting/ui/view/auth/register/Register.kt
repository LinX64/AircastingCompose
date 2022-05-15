package com.client.aircasting.ui.view.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.auth.register.components.*
import com.client.aircasting.ui.view.navigation.NavRoutes
import com.client.aircasting.ui.viewmodel.AuthViewModel
import com.client.aircasting.util.common.ProgressBarLoading
import com.client.aircasting.util.common.ShowToastBar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Register(
    authViewModel: AuthViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var profileName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val sendEmails = remember { mutableStateOf(true) }

    val isValidate by derivedStateOf { profileName.isNotBlank() && email.isNotBlank() && password.isNotBlank() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val isLoading = authViewModel.isLoading.value
    val isSuccessLoading = authViewModel.isSuccessLoading.value
    val errorMessage = authViewModel.errorMessage.value
    val errorAuth = authViewModel.errorAuth.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

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

        RegTextViews()

        Column(
            Modifier
                .padding(
                    start = dimensionResource(R.dimen.keyline_8),
                    end = dimensionResource(R.dimen.keyline_8)
                )
        ) {

            RegProfileNameTextField(
                profileName = profileName,
                onValueChange = { profileName = it },
                onClickButton = { profileName = "" },
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )

            Spacer(Modifier.padding(dimensionResource(R.dimen.keyline_2)))

            RegEmailTextField(
                email = email,
                onValueChange = { email = it },
                onClickButton = { email = "" },
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )

            Spacer(Modifier.padding(dimensionResource(R.dimen.keyline_2)))

            RegPasswordTextField(
                password = password,
                onValueChange = { password = it },
                onDone = { focusManager.clearFocus() }
            )
        }
        Spacer(Modifier.padding(dimensionResource(R.dimen.keyline_2)))

        LabelledCheckBox(
            modifier = Modifier.padding(start = dimensionResource(R.dimen.keyline_3)),
            checked = true,
            onCheckedChange = { sendEmails.value = it },
            label = stringResource(R.string.send_emails)
        )

        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_3)))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(R.dimen.keyline_8),
                    end = dimensionResource(R.dimen.keyline_8)
                )
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.aircasting_blue_400)),
            onClick = {
                keyboardController?.hide()
                authViewModel.createAccount(
                    profileName,
                    password,
                    email,
                    send_emails = sendEmails.value
                )
            }, enabled = isValidate
        ) {
            Text(
                text = stringResource(id = R.string.create_account_text_button),
                color = colorResource(id = R.color.aircasting_white),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_3)))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimensionResource(R.dimen.keyline_8))
        ) {

            Text(
                text = stringResource(id = R.string.login_prompt),
                color = colorResource(id = R.color.aircasting_grey_700),
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_1)))

            ClickableText(
                text = AnnotatedString(stringResource(R.string.login_text_button)),
                onClick = { goToLogin(true, navController) },
                style = TextStyle(
                    color = colorResource(R.color.aircasting_blue_400),
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }

    ProgressBarLoading(isLoading = isLoading)

    goToLogin(isSuccessLoading, navController)

    ShowToastBar(textMessage = errorMessage, errorAuth)
}

private fun goToLogin(isSuccessLoading: Boolean, navController: NavHostController) {
    if (isSuccessLoading) navController.navigate(NavRoutes.Login.route) { launchSingleTop = true }
}