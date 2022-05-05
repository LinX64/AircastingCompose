package com.client.aircasting.ui.auth.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.auth.viewmodel.AuthViewModel

@Composable
fun Login(navController: NavController) {
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
            Text(
                text = stringResource(id = R.string.login_header),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.keyline_10)),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5,
                color = colorResource(id = R.color.aircasting_blue_400)
            )

            Text(
                text = stringResource(id = R.string.login_description),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.keyline_5)),
                color = colorResource(id = R.color.aircasting_grey_700)
            )

            TextFields()

            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.keyline_8))
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.aircasting_blue_400)),
                onClick = { // todo

                }) {
                Text(
                    text = stringResource(id = R.string.login_text_button),
                    color = colorResource(id = R.color.aircasting_white),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_5)))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.keyline_5)),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = stringResource(id = R.string.forgot_your_password),
                    color = colorResource(
                        id = R.color.aircasting_blue_400
                    ), style = MaterialTheme.typography.body1
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.keyline_10)))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.create_account_prompt),
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.aircasting_grey_700)
                )

                Text(
                    text = stringResource(id = R.string.create_account_text_button),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.keyline_3),
                        end = dimensionResource(R.dimen.keyline_8)
                    ),
                    color = colorResource(id = R.color.aircasting_blue_400),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
fun LogicAction(profileName: String, password: String) {
    val authViewModel: AuthViewModel = hiltViewModel()
    authViewModel.login(profileName, password)
}

@Preview
@Composable
fun ShowLoginPreview() {
    val navController = rememberNavController()
    Login(navController = navController)
}