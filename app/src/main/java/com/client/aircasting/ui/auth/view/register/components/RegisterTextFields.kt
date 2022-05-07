package com.client.aircasting.ui.auth.view.register.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.aircasting.R

@Composable
fun RegisterTextFields() {
    var email by rememberSaveable { mutableStateOf("") }
    var profileName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(
                start = dimensionResource(R.dimen.keyline_5),
                end = dimensionResource(R.dimen.keyline_5)
            )
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(
                    text = stringResource(id = R.string.email_hint),
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = profileName,
            onValueChange = {
                profileName = it
            },
            label = {
                Text(
                    text = stringResource(id = R.string.profile_name_hint),
                )
            })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
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
}

@Preview
@Composable
fun ShowTextFieldsPreview() {
    RegisterTextFields()
}