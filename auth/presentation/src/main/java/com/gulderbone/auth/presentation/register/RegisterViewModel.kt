@file:Suppress("OPT_IN_USAGE_FUTURE_ERROR")

package com.gulderbone.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    fun onAction(action: RegisterAction) {
    }
}