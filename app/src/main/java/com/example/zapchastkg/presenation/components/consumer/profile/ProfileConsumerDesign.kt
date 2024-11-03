package com.example.zapchastkg110.presenation.components.consumer.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zapchastkg110.presenation.screens.auth.login.SignInViewModel

@Composable
fun ProfileScreen(viewModel: SignInViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#f2f1f6"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileHeader()
        ProfileDetails(viewModel)
    }
}



