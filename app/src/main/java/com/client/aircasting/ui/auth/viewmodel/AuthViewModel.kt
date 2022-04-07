package com.client.aircasting.ui.auth.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.aircasting.data.api.helpers.ApiServiceFactory
import com.client.aircasting.util.Settings
import com.client.aircasting.util.exceptions.ErrorHandler
import com.client.aircasting.util.exceptions.InternalAPIError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val mApiServiceFactory: ApiServiceFactory,
    private val mErrorHandler: ErrorHandler,
    private val mSettings: Settings
) : ViewModel() {
    private val progressBar = mutableStateOf(value = false)
    private val isSuccessLoading = mutableStateOf(value = false)

    fun login(profileName: String, password: String) = viewModelScope.launch {

        try {
            progressBar.value = true
            val responseService = mApiServiceFactory.get(profileName, password).login()

            when {
                responseService.isSuccessful -> {
                    isSuccessLoading.value = true

                    val body = responseService.body()
                    body?.let {
                        mSettings.login(body.email, body.authentication_token)
                    }
                }
                responseService.code() == 401 -> {
                    progressBar.value = false

                    //TODO - invalid credentials
                }
                else -> {
                    progressBar.value = false
                    mErrorHandler.handleAndDisplay(InternalAPIError())
                }
            }
            progressBar.value = false
        } catch (e: Exception) {
            progressBar.value = false
            println(e.message)
        }
    }
}