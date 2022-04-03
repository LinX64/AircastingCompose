package com.client.aircasting.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R

@Composable
fun Login(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
    ) {

        Text(
            text = stringResource(id = R.string.login_header),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            color = colorResource(id = R.color.aircasting_blue_400)
        )

        Text(
            text = stringResource(id = R.string.login_description),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            var text by remember { mutableStateOf("text") }
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.profile_name_hint),
                    )
                }
            )

        }
    }

}

@Preview
@Composable
fun ShowLoginPreview() {
    val navController = rememberNavController()
    Login(navController = navController)
}
