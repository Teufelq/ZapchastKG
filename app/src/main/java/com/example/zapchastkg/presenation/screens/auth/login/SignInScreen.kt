package com.example.zapchastkg110.presenation.screens.auth.login

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.zapchastkg110.presenation.components.login.SignInDesign
import com.example.zapchastkg110.presenation.utils.Screens

@Composable
fun SignInScreen(navHostController: NavHostController, viewModel: SignInViewModel = hiltViewModel()) {
    SignInDesign(viewModel, onClickSignUp ={
        navHostController.navigate(Screens.BottomNavBar.route){
            popUpTo(Screens.SignInScreen.route){
                inclusive = true
            }
        }
    },
        onClickForgotPassword = {
            navHostController.navigate(Screens.ForgotPasswordScreen.route){
                popUpTo(Screens.SignInScreen.route){
                    inclusive = true
                }
            }
        }
    )
}