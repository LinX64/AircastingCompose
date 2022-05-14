package com.client.aircasting.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.aircasting.data.api.helpers.ApiServiceFactory
import com.client.aircasting.data.api.responses.UserResponse
import com.client.aircasting.util.Settings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val mApiServiceFactory: ApiServiceFactory,
    private val mSettings: Settings
) : ViewModel() {
    var isLoading = mutableStateOf(false)
    var isSuccessLoading = mutableStateOf(false)
    var errorResponse = mutableStateOf("")

    fun login(profileName: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            isLoading.value = true
            val responseService = mApiServiceFactory.get(profileName, password).login()

            when {
                responseService.isSuccessful -> {
                    delay(1500L)
                    val body = responseService.body()
                    body?.let {
                        mSettings.login(body.email, body.authentication_token)
                    }
                    isSuccessLoading.value = true
                }
                responseService.code() == 401 -> errorResponse.value = responseService.errorBody().toString()
                else ->errorResponse.value = responseService.errorBody().toString()
            }

            isLoading.value = false
        } catch (e: Exception) {
            isLoading.value = false
        }
    }
}