package com.client.aircasting.ui.view.auth.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.client.aircasting.R

@Composable
fun LoginProfileNameTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    onClickButton: () -> Unit,
    onNext: (KeyboardActionScope.() -> Unit)
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        value = textValue,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(R.string.profile_name_hint),
            )
        },
        trailingIcon = {
            IconButton(
                onClick = onClickButton
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Icon Clear"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = onNext
        )
    )
}