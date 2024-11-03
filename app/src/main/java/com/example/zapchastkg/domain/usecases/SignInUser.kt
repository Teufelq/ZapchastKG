package com.example.zapchastkg110.domain.usecases

import com.example.zapchastkg110.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUser @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        authRepository.loginUser(email, password)
   /* operator fun invoke(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit){
        return authRepository.signInUser(email, password, onSuccess, onError)
    }*/
}