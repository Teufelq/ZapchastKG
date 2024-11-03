package com.example.zapchastkg110.domain.usecases

import com.example.zapchastkg110.domain.repository.AuthRepository
import javax.inject.Inject

class GetProfile @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke() = authRepository.getUserProfile()
   /* operator fun invoke(
        token: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
        list: MutableStateFlow<ProfileModel?> = MutableStateFlow<ProfileModel?>(null)){
        return authRepository.getProfile(token, onSuccess, onError, list)
    }*/
}