package com.example.zapchastkg110.di

import android.content.Context
import com.example.zapchastkg110.data.network.AuthApi
import com.example.zapchastkg110.data.repositoryImpl.AuthRepositoryImpl
import com.example.zapchastkg110.data.security.SecurePreferences
import com.example.zapchastkg110.domain.repository.AuthRepository
import com.example.zapchastkg110.domain.usecases.AuthUseCases
import com.example.zapchastkg110.domain.usecases.GetProfile
import com.example.zapchastkg110.domain.usecases.SignInUser
import com.example.zapchastkg110.domain.usecases.SignUpUser
import com.example.zapchastkg110.domain.usecases.VerifyUser
import com.example.zapchastkg110.presenation.utils.Constance.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): AuthApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSecurePreferences(@ApplicationContext context: Context): SecurePreferences {
        return SecurePreferences(context)
    }


    @Provides
    @Singleton
    fun providesAuthRepository(authApi: AuthApi, securePreferences: SecurePreferences): AuthRepository = AuthRepositoryImpl(authApi, securePreferences)

    @Provides
    @Singleton
    fun provideAuthUseCases(authRepository: AuthRepository) =
        AuthUseCases(
            SignUpUser(authRepository),
            SignInUser(authRepository),
            GetProfile(authRepository),
            VerifyUser(authRepository)
        )

}