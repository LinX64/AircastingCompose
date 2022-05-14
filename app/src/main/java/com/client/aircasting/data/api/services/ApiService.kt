package com.client.aircasting.data.api.services

import com.client.aircasting.data.api.helpers.Constants
import com.client.aircasting.data.api.responses.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    /* Auth Requests */
    @GET(Constants.urlLogin)
    suspend fun login(): Response<UserResponse>
}




