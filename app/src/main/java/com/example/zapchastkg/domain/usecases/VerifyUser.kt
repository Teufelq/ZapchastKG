package com.example.zapchastkg110.domain.usecases

import com.example.zapchastkg110.domain.repository.AuthRepository
import javax.inject.Inject

class VerifyUser @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, code: String) =
        authRepository.verifyEmail(email, code)
   /* operator fun invoke(email: String, code: String, onSuccess: () -> Unit, onError: (String) -> Unit){
        return authRepository.verifyUser(email, code, onSuccess, onError)
    }*/
}