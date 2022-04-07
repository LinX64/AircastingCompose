package com.client.aircasting.ui.main.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.client.aircasting.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    var movieListResponse: List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    /*fun getMovieList() {
        viewModelScope.launch {
            try {
                movieListResponse = apiService.getMovies()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }*/
}