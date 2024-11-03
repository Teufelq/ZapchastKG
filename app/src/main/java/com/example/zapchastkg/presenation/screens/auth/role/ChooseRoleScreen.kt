package com.example.zapchastkg110.presenation.screens.auth.role

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.zapchastkg110.presenation.components.role.ChooseRoleDesign
import com.example.zapchastkg110.presenation.utils.Screens

@Composable
fun ChooseRoleScreen(navHostController: NavHostController) {
    ChooseRoleDesign( onClickSeller = {
        navHostController.navigate(Screens.SellerSignUpScreen.route) {
        popUpTo(Screens.ChooseRole.route) {
            inclusive = true
        }
    }},
        onClickConsumer = {
            navHostController.navigate(Screens.ConsumerSignUpScreen.route) {
            popUpTo(Screens.ChooseRole.route) {
                inclusive = true
            }
        }},)
}