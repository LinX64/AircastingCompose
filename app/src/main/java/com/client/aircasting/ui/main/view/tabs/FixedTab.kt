package com.client.aircasting.ui.main.view.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.client.aircasting.model.Movie
import com.client.aircasting.ui.main.viewmodel.MainViewModel
import com.client.aircasting.util.ExpandableCard

@Composable
fun FixedScreen(mainViewModel: MainViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {

       /* SessionsList(movieList = mainViewModel.movieListResponse)
        mainViewModel.getMovieList()*/
    }
}

@Preview(showBackground = true)
@Composable
fun FixedScreenPreview() {
    FixedScreen()
}

@Composable
fun SessionsList(movieList: List<Movie>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            SessionsItem(movie = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SessionsItem(movie: Movie, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {
    val backgroundColor =
        if (index == selectedIndex) MaterialTheme.colors.primary else MaterialTheme.colors.background
    val textColour =
        if (index == selectedIndex) Color.White else Color.Black

    Row(
        Modifier
            .padding(4.dp)
            .fillMaxSize()
    ) {

        ExpandableCard(
            date = "02/12/2012 - 12:00 pm - 1:00 am",
            title = movie.name,
            type = "Fixed : Airbeam 3",
            lastMinute = "Last minute measurements",
            description = ""
        )
    }
}