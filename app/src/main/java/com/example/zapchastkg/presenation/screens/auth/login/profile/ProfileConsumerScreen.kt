package com.example.zapchastkg110.presenation.screens.auth.login.profile

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.example.zapchastkg110.presenation.components.consumer.profile.ProfileScreen
import com.example.zapchastkg110.presenation.screens.auth.login.SignInViewModel

@Composable
fun ProfileConsumerScreen(navHostController: NavHostController, signInViewModel: SignInViewModel = hiltViewModel()) {
    ProfileScreen(signInViewModel)
}