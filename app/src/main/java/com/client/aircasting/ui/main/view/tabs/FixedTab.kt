package com.client.aircasting.ui.main.view.tabs

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.client.aircasting.model.Movie
import com.client.aircasting.ui.main.viewmodel.MainViewModel
import com.client.aircasting.util.ExpandableCard

@Composable
fun FixedScreen() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {

        val viewModel: MainViewModel = viewModel(LocalContext.current as ComponentActivity)
        SessionsList(movieList = viewModel.movieListResponse)
        viewModel.getMovieList()
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

    ExpandableCard(
        date = "02/12/2012 - 12:00 pm - 1:00 am",
        title = movie.name,
        type = "Fixed : Airbeam 3",
        lastMinute = "Last minute measurements",
        description = ""
    )
    /* Surface(color = backgroundColor) {
         Row(
             Modifier
                 .padding(4.dp)
                 .fillMaxSize()
         ) {

             Image(
                 painter = rememberImagePainter(
                     data = movie.imageUrl,
                     builder = {
                         scale(Scale.FILL)
                         transformations(CircleCropTransformation())

                     }
                 ),
                 contentDescription = movie.desc,
                 modifier = Modifier
                     .fillMaxHeight()
                     .weight(0.2f)
                     .padding(start = 10.dp)
             )


             Column(
                 verticalArrangement = Arrangement.Center,
                 modifier = Modifier
                     .padding(start = 15.dp, end = 4.dp)
                     .fillMaxHeight()
                     .weight(0.8f)
             ) {
                 Text(
                     text = movie.name,
                     fontSize = 16.sp,
                     fontWeight = FontWeight.Bold,
                     color = textColour
                 )
                 Text(
                     text = movie.category,
                     fontSize = 13.sp, color = Color.Black,
                     modifier = Modifier
                         .background(
                             Color.Green
                         )
                         .padding(4.dp)
                 )
                 Text(
                     text = movie.desc,
                     fontSize = 14.sp,
                     color = textColour,
                     maxLines = 4,
                     overflow = TextOverflow.Ellipsis
                 )

             }
         }
     }*/
}