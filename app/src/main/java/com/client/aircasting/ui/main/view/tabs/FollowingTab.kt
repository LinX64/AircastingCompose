package com.client.aircasting.ui.main.view.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.client.aircasting.ui.main.view.MovieList
import com.client.aircasting.ui.main.viewmodel.MainViewModel

@Composable
fun FollowingScreen() {
    val mainViewModel = hiltViewModel<MainViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        MovieList(movieList = mainViewModel.movieListResponse)
        mainViewModel.getMovieList()
    }
}

@Preview(showBackground = true)
@Composable
fun FollowingScreenPreview() {
    FollowingScreen()
}