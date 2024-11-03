package com.example.zapchastkg110.data.repositoryImpl

import android.util.Log
import com.example.zapchastkg110.data.network.AuthApi
import com.example.zapchastkg110.data.security.SecurePreferences
import com.example.zapchastkg110.domain.model.auth.LoginRequest
import com.example.zapchastkg110.domain.model.auth.ProfileModel
import com.example.zapchastkg110.domain.model.auth.RegisterModel
import com.example.zapchastkg110.domain.model.auth.VerifyRequest
import com.example.zapchastkg110.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: AuthApi,
    private val securePreferences: SecurePreferences
) : AuthRepository {
    override suspend fun registerUser(registerModel: RegisterModel, password2: String): Flow<Result<Unit>> = flow {
        val bodyParameters = mapOf(
            "username" to registerModel.username,
            "password" to registerModel.password,
            "password2" to password2,
            "email" to registerModel.email,
            "phone_number" to registerModel.phone_number,
            "user_type" to registerModel.user_type
        )
        val response = apiService.registerUser(bodyParameters)
        if (response.isSuccessful) {
            emit(Result.success(Unit))
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string() ?: "Unknown error")))
        }
    }.catch { e -> emit(Result.failure(e)) }

    override suspend fun loginUser(email: String, password: String): Flow<Result<String>> = flow {
        val response = apiService.loginUser(LoginRequest(email, password))
        if (response.isSuccessful) {
            val token = response.body()?.access.orEmpty()
            securePreferences.saveToken(token) // Сохраните токен
            emit(Result.success(token))
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string() ?: "Unknown error")))
        }
    }.catch { e -> emit(Result.failure(e)) }

    override suspend fun verifyEmail(email: String, code: String): Flow<Result<Unit>> = flow {
        val response = apiService.verifyEmail(VerifyRequest(email, code))
        if (response.isSuccessful) {
            emit(Result.success(Unit))
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string() ?: "Verification error")))
        }
    }.catch { e -> emit(Result.failure(e)) }


    override suspend fun getUserProfile(): Flow<Result<ProfileModel>> = flow {
        val token = securePreferences.getToken() // Получите токен
        if (token != null) {
            val response = apiService.getUserProfile("Bearer $token")
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Exception(response.errorBody()?.string() ?: "Unknown error")))
            }
        } else {
            emit(Result.failure(Exception("Token not found")))
        }
    }.catch { e ->
        emit(Result.failure(e))
    }
}
    /*  override fun signUpUser(
           registerModel: RegisterModel,
           password2: String,
           onSuccess: () -> Unit,
           onError: (String) -> Unit
       ) {
           val bodyParameters = mapOf(
               "username" to registerModel.username,
               "password" to registerModel.password,
               "password2" to password2,
               "email" to registerModel.email,
               "phone_number" to registerModel.phone_number,
               "user_type" to registerModel.user_type
           )

           authApi.registerUser(bodyParameters).enqueue(object : Callback<RegisterModel> {
               override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>) {
                   if (response.isSuccessful) {
                       onSuccess()
                   } else {
                       val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                       onError(errorMessage)
                   }
               }

               override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                   onError(t.message ?: "Network error")
               }
           })
       }

       override fun signInUser(
           email: String,
           password: String,
           onSuccess: () -> Unit,
           onError: (String) -> Unit
       ) {
           val loginRequest = LoginRequest(email, password)
           authApi.loginUser(loginRequest).enqueue(object : Callback<LoginModel> {
               override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                   if (response.isSuccessful) {
                       val token = response.body()?.access.orEmpty()
                       getProfile(token, onSuccess, onError)
                   } else {
                       val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                       onError(errorMessage)
                   }
               }
               override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                   onError(t.message ?: "Network error")
               }
           })
       }

       override fun getProfile(
           token: String,
           onSuccess: () -> Unit,
           onError: (String) -> Unit,
           list: MutableStateFlow<ProfileModel?>
       ) {
           authApi.getUserProfile("Bearer $token").enqueue(object : Callback<ProfileModel> {
               override fun onResponse(call: Call<ProfileModel>, response: Response<ProfileModel>) {
                   if (response.isSuccessful) {
                       list.value = response.body()
                       onSuccess()
                   } else {
                       val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                       onError(errorMessage)
                   }
               }

               override fun onFailure(call: Call<ProfileModel>, t: Throwable) {
                   onError(t.message ?: "Network error")
               }
           })
       }

       override fun verifyUser(
           email: String,
           code: String,
           onSuccess: () -> Unit,
           onError: (String) -> Unit,
       ) {
           val verifyRequest = VerifyRequest(email, code)
           authApi.verifyEmail(verifyRequest).enqueue(object : Callback<VerifyEmailResponse> {
               override fun onResponse(call: Call<VerifyEmailResponse>, response: Response<VerifyEmailResponse>) {
                   if (response.isSuccessful) {
                       onSuccess()
                   } else {
                       val errorMessage = response.errorBody()?.string() ?: "Ошибка верификации"
                       onError(errorMessage)
                   }
               }

               override fun onFailure(call: Call<VerifyEmailResponse>, t: Throwable) {
                   onError(t.message ?: "Ошибка сети")
               }
           })
       }*/

