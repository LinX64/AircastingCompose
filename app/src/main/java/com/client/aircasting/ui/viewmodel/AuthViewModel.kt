package com.client.aircasting.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.aircasting.data.api.helpers.ApiServiceFactory
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
    var errorMessage = mutableStateOf("")
    val errorAuth = mutableStateOf(false)

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
                    isLoading.value = false
                }
                else -> responseService.errorBody()?.let { error ->
                    errorAuth.value = true
                    delay(1500L)
                    errorAuth.value = false
                    error.close()
                }
            }

            isLoading.value = false
        } catch (e: Exception) {
            isLoading.value = false
            errorMessage.value = e.message.toString()
        }
    }
}