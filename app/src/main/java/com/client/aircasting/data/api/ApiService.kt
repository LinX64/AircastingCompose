package com.client.aircasting.data.api

import com.client.aircasting.model.Movie
import retrofit2.http.GET

interface ApiService {

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>
}