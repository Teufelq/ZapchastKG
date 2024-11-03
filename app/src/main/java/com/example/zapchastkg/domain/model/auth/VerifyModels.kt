package com.example.zapchastkg110.domain.model.auth

data class LoginRequest(
    val email: String,
    val password: String
)

data class VerifyRequest(
    val email: String,
    val code: String
)

data class VerifyEmailResponse(
    val message: String
)