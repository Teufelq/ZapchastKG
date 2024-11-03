package com.example.zapchastkg110.presenation.utils

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash_screen")
    object OnBoardScreen : Screens("on_board_screen")
    object ChooseRole : Screens("choose_role")
    object SellerSignUpScreen : Screens("seller_sign_up_screen")
    object ConsumerSignUpScreen : Screens("consumer_sign_up_screen")
    object SignInScreen : Screens("sign_in_screen")
    object ForgotPasswordScreen : Screens("forgot_password_screen")
    object MainConsumerScreen : Screens("main_consumer_screen",)
    object SearchConsumerScreen : Screens("search_consumer_screen",)
    object FavoriteScreenConsumer : Screens("favorite_screen_consumer",)
    object ChatConsumerScreen : Screens("chat_consumer_screen", )
    object ProfileConsumerScreen : Screens("profile_consumer_screen",)
    object VerifyEmailScreen : Screens("verify_email_screen")
    object BottomNavBar : Screens("btm",)
}