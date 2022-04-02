package com.client.aircasting.ui.main.view.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.aircasting.R

@Composable
fun MobileActiveScreen() {
    Column(Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.dashboard_empty_mobile_active_header)
            )
        }

        BottomCardView()
    }
}

@Preview(showBackground = true)
@Composable
fun MobileActiveScreenPreview() {
    MobileActiveScreen()
}

@Composable
fun BottomCardView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .padding(start = 24.dp, bottom = 54.dp, end = 24.dp)
                .fillMaxWidth()
                .size(130.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = 5.dp,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.didyouknowimage),
                    ""
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = stringResource(id = R.string.did_you_know),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )

                    Text(
                        text = stringResource(id = R.string.did_you_know_box_tip_1),
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                    )

                }
            }
        }

    }
}