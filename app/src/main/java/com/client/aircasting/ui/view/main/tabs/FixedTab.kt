package com.client.aircasting.ui.view.main.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.aircasting.util.session_card.ExpandableCard

@Composable
fun FixedScreen() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        SessionsList()
    }
}

@Composable
fun SessionsList() {
    LazyColumn {
        items(5) { index ->
            SessionsItem()
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SessionsItem() {
    Row(
        Modifier.fillMaxWidth()
    ) {

        ExpandableCard(
            date = "02/12/2012 - 12:00 pm - 1:00 am",
            title = "HabitatMap HQ",
            type = "Fixed : Airbeam 3",
            lastMinute = "Last minute measurements"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FixedScreenPreview() {
    FixedScreen()
}


@Preview(showBackground = true)
@Composable
fun ShowCardItem() {
    SessionsItem()
}