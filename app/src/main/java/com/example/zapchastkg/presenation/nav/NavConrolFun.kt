package com.example.zapchastkg110.presenation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zapchastkg110.presenation.screens.board.OnBoardScreen
import com.example.zapchastkg110.presenation.screens.auth.signUp.ConsumerSignUpScreen
import com.example.zapchastkg110.presenation.screens.consumer.chat.ChatConsumerScreen
import com.example.zapchastkg110.presenation.screens.consumer.favorite.FavoriteScreenConsumer
import com.example.zapchastkg110.presenation.screens.consumer.main.MainConsumerScreen
import com.example.zapchastkg110.presenation.screens.auth.login.profile.ProfileConsumerScreen
import com.example.zapchastkg110.presenation.screens.consumer.search.SearchConsumerScreen
import com.example.zapchastkg110.presenation.screens.auth.recovery.RecoveryPasswordScreen
import com.example.zapchastkg110.presenation.screens.auth.login.SignInScreen
import com.example.zapchastkg110.presenation.screens.auth.login.SignInViewModel
import com.example.zapchastkg110.presenation.screens.auth.role.ChooseRoleScreen
import com.example.zapchastkg110.presenation.screens.auth.signUp.SellerSignUpScreen
import com.example.zapchastkg110.presenation.screens.auth.verify.VerifyEmailScreen
import com.example.zapchastkg110.presenation.utils.Screens

@Composable
fun NavControlFun(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.ChooseRole.route
    ) {
        composable(route = Screens.BottomNavBar.route){
            BottomBar(navController)
        }
        composable(route = Screens.OnBoardScreen.route){
            OnBoardScreen(navController)
        }
        composable(route = Screens.ChooseRole.route){
            ChooseRoleScreen(navController)
        }
        composable(route = Screens.SellerSignUpScreen.route){
            SellerSignUpScreen(navController)
        }
        composable(route = Screens.ConsumerSignUpScreen.route){
            ConsumerSignUpScreen(navController)
        }
        composable(route = Screens.SignInScreen.route){
            SignInScreen(navController)
        }
        composable(route = Screens.ForgotPasswordScreen.route){
            RecoveryPasswordScreen(navHostController = navController)
        }
        composable(route = Screens.MainConsumerScreen.route){
            MainConsumerScreen(navController)
        }
        composable(route = Screens.SearchConsumerScreen.route){
            SearchConsumerScreen(navController)
        }
        composable(route = Screens.FavoriteScreenConsumer.route){
            FavoriteScreenConsumer(navController)
        }
        composable(route = Screens.ProfileConsumerScreen.route){
            ProfileConsumerScreen(navHostController = navController)
        }
        composable (route = Screens.ChatConsumerScreen.route){
            ChatConsumerScreen(navController)
        }
        composable(route = "${Screens.VerifyEmailScreen.route}/{emailState}"){ backStackEntry ->
            val email = backStackEntry.arguments?.getString("emailState") ?: ""
            VerifyEmailScreen(navController, email)
        }
    }
}