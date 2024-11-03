package com.example.zapchastkg110.presenation.screens.auth.signUp


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zapchastkg110.domain.model.auth.RegisterModel
import com.example.zapchastkg110.domain.usecases.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isRegistered = MutableStateFlow(false)
    val isRegistered: StateFlow<Boolean> = _isRegistered

    fun registerUser(registerModel: RegisterModel, password2: String) {
        viewModelScope.launch{
            _loading.value = true
            authUseCases.signUpUser(registerModel, password2).collect { result ->
                _loading.value = false
                result.onSuccess {
                    _isRegistered.value = true
                }.onFailure { exception ->
                    _error.value = exception.message
                }
            }
        }
    }
        /*fun signUpUser(registerModel: RegisterModel,
                           password2: String,
                           onSuccess: () -> Unit,
                           onError: (String) -> Unit){
        viewModelScope.launch {
            authUseCases.signUpUser.invoke(registerModel, password2, onSuccess, onError)
        }
    }*/
}