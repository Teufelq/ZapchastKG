package com.example.zapchastkg110.presenation.screens.auth.signUp

import androidx.compose.runtime.Composable

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.zapchastkg110.presenation.components.consumer.ConsumerSignUpDesign
import com.example.zapchastkg110.presenation.utils.Screens


@Composable
fun ConsumerSignUpScreen(navHostController: NavHostController, viewModel: SignUpViewModel = hiltViewModel()) {
    ConsumerSignUpDesign(navHostController, viewModel = viewModel,
        onClickEnter = {
        navHostController.navigate(Screens.SignInScreen.route){
            popUpTo(Screens.ConsumerSignUpScreen.route){
                inclusive = true
            }
        } })
}
