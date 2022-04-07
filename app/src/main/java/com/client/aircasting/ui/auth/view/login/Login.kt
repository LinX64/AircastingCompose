package com.client.aircasting.ui.auth.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.auth.viewmodel.AuthViewModel

@Composable
fun Login(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    var profileName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {

        Text(
            text = stringResource(id = R.string.login_header),
            modifier = Modifier.padding(start = 30.dp, top = 40.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            color = colorResource(id = R.color.aircasting_blue_400)
        )

        Text(
            text = stringResource(id = R.string.login_description),
            modifier = Modifier.padding(start = 30.dp, top = 20.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 20.dp, end = 30.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = profileName,
                onValueChange = {
                    profileName = it
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.profile_name_hint),
                    )
                }
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 20.dp, end = 30.dp)
        ) {
            var showPassword by remember { mutableStateOf(false) }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.password_hint),
                    )
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = {
                        showPassword = !showPassword
                    }) {
                        Icon(
                            imageVector = if (showPassword)
                                Icons.Filled.Visibility
                            else
                                Icons.Filled.VisibilityOff, ""
                        )
                    }
                })
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 30.dp, end = 30.dp)
        ) {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.aircasting_blue_400)
                ),
                onClick = {

                    authViewModel.login(profileName, password)

                }) {
                Text(
                    text = stringResource(id = R.string.login_text_button),
                    color = colorResource(id = R.color.aircasting_white),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, top = 20.dp, end = 30.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = stringResource(id = R.string.forgot_your_password),
                    color = colorResource(
                        id = R.color.aircasting_blue_400
                    ), style = MaterialTheme.typography.body1
                )
            }
        }

    }

}

@Preview
@Composable
fun ShowLoginPreview() {
    val navController = rememberNavController()
    Login(navController = navController)
}