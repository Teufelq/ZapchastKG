package com.example.zapchastkg110.presenation.screens.auth.verify

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zapchastkg110.domain.model.auth.VerifyRequest
import com.example.zapchastkg110.domain.usecases.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerifyViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isVerified = MutableStateFlow(false)
    val isVerified: StateFlow<Boolean> = _isVerified

    fun verifyEmail(email: String, code: String) {
        viewModelScope.launch {
            _loading.value = true
           authUseCases.verifyUser(email, code).collect { result ->
                _loading.value = false
                result.onSuccess {
                    _isVerified.value = true
                }.onFailure { exception ->
                    _error.value = exception.message
                }
            }
        }
    }
}