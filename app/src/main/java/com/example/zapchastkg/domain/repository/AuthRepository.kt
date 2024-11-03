package com.example.zapchastkg110.domain.repository

import com.example.zapchastkg110.domain.model.auth.ProfileModel
import com.example.zapchastkg110.domain.model.auth.RegisterModel
import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    suspend fun registerUser(registerModel: RegisterModel, password2: String): Flow<Result<Unit>>
    suspend fun loginUser(email: String, password: String): Flow<Result<String>>
    suspend fun verifyEmail(email: String, code: String): Flow<Result<Unit>>
    suspend fun getUserProfile(): Flow<Result<ProfileModel>>
}
    /* fun signUpUser(registerModel: RegisterModel, password2: String, onSuccess: () -> Unit, onError: (String) -> Unit)
     fun signInUser(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit)
     fun getProfile(token: String, onSuccess: () -> Unit, onError: (String) -> Unit, list: MutableStateFlow<ProfileModel?> = MutableStateFlow<ProfileModel?>(null))
     fun verifyUser(email: String, code: String, onSuccess: () -> Unit, onError: (String) -> Unit)*/
