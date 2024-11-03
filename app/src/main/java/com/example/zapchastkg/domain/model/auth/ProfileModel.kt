package com.example.zapchastkg110.domain.model.auth

import com.google.gson.annotations.SerializedName

data class ProfileModel(
    val id: Int,
    val username: String,
    val email: String,
    @SerializedName("phone_number")val phoneNumber: String,
    @SerializedName("user_type")val userType: String,
    val email_verified: Boolean
)
