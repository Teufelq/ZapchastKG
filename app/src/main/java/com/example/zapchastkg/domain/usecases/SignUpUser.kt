package com.example.zapchastkg110.domain.usecases

import com.example.zapchastkg110.domain.model.auth.RegisterModel
import com.example.zapchastkg110.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUser @Inject constructor(private val authRepository:AuthRepository) {
    suspend operator fun invoke(registerModel: RegisterModel, password2: String) =
        authRepository.registerUser(registerModel, password2)
   /* operator fun invoke(registerModel: RegisterModel, password2: String, onSuccess: () -> Unit, onError: (String) -> Unit)
       = auth.signUpUser(registerModel, password2, onSuccess, onError)*/

}