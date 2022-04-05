package com.client.aircasting.ui.auth

import com.client.aircasting.data.api.ApiServiceFactory
import com.client.aircasting.util.Settings
import com.client.aircasting.util.exceptions.ErrorHandler
import com.client.aircasting.util.exceptions.InternalAPIError
import com.client.aircasting.util.exceptions.UnexpectedAPIError
import pl.llp.aircasting.networking.responses.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(
    val mSettings: Settings,
    private val mErrorHandler: ErrorHandler,
    private val mApiServiceFactory: ApiServiceFactory
) {
    fun performLogin(username: String, password: String,
                     successCallback: () -> Unit,
                     errorCallback: () -> Unit
    ) {
        val apiService = mApiServiceFactory.get(username, password)
        val call = apiService.login()

        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                when {
                    response.isSuccessful -> {
                        val body = response.body()
                        body?.let {
                            mSettings.login(body.email, body.authentication_token)
                        }
                        successCallback()
                    }
                    response.code() == 401 -> {
                        errorCallback()
                    }
                    else -> {
                        mErrorHandler.handleAndDisplay(InternalAPIError())
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                mErrorHandler.handleAndDisplay(UnexpectedAPIError(t))
            }
        })
    }
}
