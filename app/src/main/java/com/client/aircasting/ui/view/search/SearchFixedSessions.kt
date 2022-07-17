package com.client.aircasting.ui.view.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.client.aircasting.R

@Composable
fun SearchFixedSessions() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aircasting_white))
    ) {
        val (imageView, txtTitle, textInput, txtDesc, btn) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(imageView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(start = 34.dp, top = 40.dp),
            painter = painterResource(id = R.drawable.chevron_left),
            contentDescription = ""
        )

        Text(
            modifier = Modifier
                .constrainAs(txtTitle) {
                    top.linkTo(imageView.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 40.dp, top = 20.dp),
            style = MaterialTheme.typography.h4,
            color = colorResource(id = R.color.aircasting_dark_blue),
            text = "Search",
            fontWeight = FontWeight.Bold,
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(textInput) {
                    top.linkTo(txtTitle.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 30.dp, top = 20.dp, end = 30.dp),
            value = "Search",
            onValueChange = {}
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowSearchFixedSessions() {
    SearchFixedSessions()
}