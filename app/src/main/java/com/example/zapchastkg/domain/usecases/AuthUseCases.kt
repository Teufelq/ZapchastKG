package com.example.zapchastkg110.domain.usecases

data class AuthUseCases (
    val signUpUser : SignUpUser,
    val signInUser: SignInUser,
    val getProfile: GetProfile,
    val verifyUser: VerifyUser
)