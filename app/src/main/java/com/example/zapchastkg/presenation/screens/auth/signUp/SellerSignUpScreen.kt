package com.example.zapchastkg110.presenation.screens.auth.signUp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.zapchastkg110.presenation.components.seller.SellerSignUpDesign
import com.example.zapchastkg110.presenation.utils.Screens

@Composable
fun SellerSignUpScreen(navHostController: NavHostController, viewModel: SignUpViewModel = hiltViewModel()){
    SellerSignUpDesign(navHostController, viewModel, onClickEnter = {
        navHostController.navigate(Screens.SignInScreen.route) {
        popUpTo(Screens.SellerSignUpScreen.route) {
            inclusive = true
        }
    }})
}