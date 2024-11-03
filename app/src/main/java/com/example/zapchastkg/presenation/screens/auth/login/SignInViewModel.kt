package com.example.zapchastkg110.presenation.screens.auth.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zapchastkg110.domain.model.auth.LoginRequest
import com.example.zapchastkg110.domain.model.auth.ProfileModel
import com.example.zapchastkg110.domain.usecases.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token

    private val _isLogined = MutableStateFlow(false)
    val isLogined: StateFlow<Boolean> = _isLogined

    private val _profile = MutableStateFlow<ProfileModel?>(null)
    val profile: StateFlow<ProfileModel?> = _profile

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _loading.value = true
            authUseCases.signInUser(email, password).collect { result ->
                _loading.value = false
                result.onSuccess { authToken ->
                    _token.value = authToken
                    _isLogined.value = true
                }.onFailure { exception ->
                    _error.value = exception.message
                }
            }
        }
    }

    fun fetchProfile() {
        viewModelScope.launch {
            authUseCases.getProfile().collect { result ->
                result.onSuccess { profileData ->
                    _profile.value = profileData
                    Log.d("ProfileViewModel", "Profile data fetched: $profileData")
                }.onFailure { exception ->
                    Log.e("ProfileViewModel", "Failed to fetch profile data: ${exception.message}")
                }
            }
        }
    }
}
