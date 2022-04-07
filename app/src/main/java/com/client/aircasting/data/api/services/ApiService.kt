package com.client.aircasting.data.api.services

import com.client.aircasting.data.api.helpers.Constants
import com.client.aircasting.data.api.responses.UserResponse
import com.client.aircasting.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    /* Auth operations */
    @GET(Constants.urlLogin)
    suspend fun login(): Response<UserResponse>

    //TODO for sessions after login
    @GET(Constants.urlGetMovies)
    suspend fun getSessions(): List<Movie>
}



