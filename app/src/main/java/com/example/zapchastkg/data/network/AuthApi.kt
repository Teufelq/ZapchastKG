package com.example.zapchastkg110.data.network

import com.example.zapchastkg110.domain.model.auth.LoginModel
import com.example.zapchastkg110.domain.model.auth.LoginRequest
import com.example.zapchastkg110.domain.model.auth.ProfileModel
import com.example.zapchastkg110.domain.model.auth.RegisterModel
import com.example.zapchastkg110.domain.model.auth.VerifyEmailResponse
import com.example.zapchastkg110.domain.model.auth.VerifyRequest

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {
       @POST("users/register/")
       suspend fun registerUser(@Body registerModel: Map<String, String?>): Response<RegisterModel>

       @POST("users/login/")
       suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginModel>

       @POST("users/verify-email/")
       suspend fun verifyEmail(@Body verifyRequest: VerifyRequest): Response<VerifyEmailResponse>

       @GET("users/profile/")
       suspend fun getUserProfile(@Header("Authorization") token: String): Response<ProfileModel>
}
   /* @POST("users/register/")
    fun registerUser(@Body registerModel: Map<String, String?>): Call<RegisterModel>

    @POST("users/login/")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginModel>

    @POST("users/verify-email/")
    fun verifyEmail(@Body verifyRequest: VerifyRequest): Call<VerifyEmailResponse>

    @GET("users/profile/")
    fun getUserProfile(@Header("Authorization") token: String): Call<ProfileModel>*/



