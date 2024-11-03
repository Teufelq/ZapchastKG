package com.example.zapchastkg110.domain.model.auth

data class  RegisterModel(
    val id: Int,
    val username: String,
    val password: String?,
    val email: String,
    val phone_number: String,
    val user_type: String,
    val email_verified: Boolean
)