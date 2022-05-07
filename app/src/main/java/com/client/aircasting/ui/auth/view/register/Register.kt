package com.client.aircasting.ui.auth.view.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.auth.view.register.components.LabelledCheckBox
import com.client.aircasting.ui.auth.view.register.components.RegisterTextFields
import com.client.aircasting.ui.navigation.NavRoutes

@Composable
fun Register(navController: NavHostController) {
    val checkedState = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_10)))

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

        Text(
            text = stringResource(R.string.create_account_header),
            modifier = Modifier.padding(start = 34.dp),
            color = colorResource(id = R.color.aircasting_blue_400),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

        Text(
            text = stringResource(R.string.create_account_description),
            modifier = Modifier.padding(start = dimensionResource(R.dimen.keyline_9)),
            color = colorResource(id = R.color.aircasting_grey_700),
            style = MaterialTheme.typography.body1,
        )

        RegisterTextFields()

        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_3)))

        LabelledCheckBox(
            checked = true,
            onCheckedChange = { checkedState.value = it },
            label = stringResource(R.string.send_emails)
        )

        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_3)))

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.keyline_5),
                end = dimensionResource(R.dimen.keyline_5)
            )
            .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.aircasting_blue_400)),
            onClick = { // todo

            }) {
            androidx.compose.material.Text(
                text = stringResource(id = R.string.create_account_text_button),
                color = colorResource(id = R.color.aircasting_white),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_3)))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimensionResource(R.dimen.keyline_5))
        ) {

            Text(
                text = stringResource(id = R.string.login_prompt),
                color = colorResource(id = R.color.aircasting_grey_700),
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.keyline_1)))

            ClickableText(
                text = AnnotatedString(stringResource(R.string.login_text_button)),
                onClick = {
                    goToLogin(navController)
                },
                style = TextStyle(
                    color = colorResource(R.color.aircasting_blue_400),
                    fontWeight = FontWeight.Bold
                )
            )
        }

    }
}

private fun goToLogin(navController: NavController) {
    navController.navigate(NavRoutes.Login.route)
}

@Preview
@Composable
fun ShowRegisterPreview() {
    val navController = rememberNavController()
    Register(navController = navController)
}
