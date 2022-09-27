package com.client.aircasting.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.aircasting.data.api.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    fun getSessionsList() = viewModelScope.launch(Dispatchers.IO) {

        //TODO: get sessions list from repository
    }
}