package com.client.aircasting.ui.view.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.client.aircasting.R

@Composable
fun SearchSessions() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (imageView, txtTitle, textInput, txtDesc, btn) = createRefs()

        Text(
            modifier = Modifier
                .constrainAs(txtTitle) {
                    top.linkTo(imageView.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 40.dp, top = 20.dp),
            style = MaterialTheme.typography.h4,
            color = colorResource(id = R.color.aircasting_dark_blue),
            text = stringResource(id = R.string.search_session_query_hint),
            fontWeight = FontWeight.Bold,
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowSearchFixedSessionsResult() {
    SearchSessions()
}