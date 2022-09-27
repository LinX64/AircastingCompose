package com.client.aircasting.data.api

import com.client.aircasting.data.api.helpers.Constants
import com.client.aircasting.data.api.params.CreateAccountBody
import com.client.aircasting.data.api.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    /* GET Requests */
    @GET(Constants.urlLogin)
    suspend fun login(): Response<UserResponse>

    /* POST Requests */
    @POST(Constants.urlCreateAccount)
    suspend fun createAccount(@Body body: CreateAccountBody): Response<UserResponse>
}




