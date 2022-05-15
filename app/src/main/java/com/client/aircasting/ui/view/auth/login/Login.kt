package com.client.aircasting.ui.view.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.client.aircasting.R
import com.client.aircasting.ui.view.auth.login.components.*
import com.client.aircasting.ui.view.navigation.NavRoutes
import com.client.aircasting.ui.viewmodel.AuthViewModel
import com.client.aircasting.util.common.ProgressBarLoading
import com.client.aircasting.util.common.ShowToastBar

@Composable
fun Login(
    authViewModel: AuthViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var profileName by rememberSaveable { mutableStateOf(value = "") }
    var password by rememberSaveable { mutableStateOf(value = "") }
    val isValidate by derivedStateOf { profileName.isNotBlank() && password.isNotBlank() }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = dimensionResource(R.dimen.keyline_8),
                    end = dimensionResource(R.dimen.keyline_8)
                )
        ) {

            TextsLogin()

            LoginEmailTextField(
                textValue = profileName,
                onValueChange = { profileName = it },
                onClickButton = { profileName = "" },
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            LoginPasswordTextField(
                password = password,
                onValueChange = { password = it },
                onDone = { focusManager.clearFocus() }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.keyline_8))
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.aircasting_blue_400)),
                onClick = { authViewModel.login(profileName, password) }, enabled = isValidate
            ) {
                Text(
                    text = stringResource(id = R.string.login_text_button),
                    color = colorResource(id = R.color.aircasting_white),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

            BoxText()

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

            LastLoginText()
        }
    }

    ProgressBarLoading(isLoading = isLoading)

    goToDashboard(isSuccessLoading, navController)

    ShowToastBar(textMessage = errorMessage, errorAuth)

}

private fun goToDashboard(isSuccessLoading: Boolean, navController: NavHostController) {
    if (isSuccessLoading)
        navController.navigate(NavRoutes.Dashboard.route) {
            launchSingleTop = true
        }

}
