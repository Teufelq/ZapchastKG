package com.example.zapchastkg110.presenation.components.consumer.profile

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg110.presenation.screens.auth.login.SignInViewModel


@Composable
fun ProfileDetails(signInViewModel: SignInViewModel) {
    val profileData by signInViewModel.profile.collectAsState()

    Log.d("ProfileDetails", "Profile data in UI after observeAsState: $profileData")

    LaunchedEffect (Unit){
        signInViewModel.fetchProfile()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        profileData?.let { profile ->
            Text(text = "ID: ${profile.id}", fontSize = 18.sp, color = Color.Black)
            Text(text = "Username: ${profile.username}", fontSize = 18.sp, color = Color.Black)
            Text(text = "Email: ${profile.email}", fontSize = 18.sp, color = Color.Black)
            Text(text = "Phone: ${profile.phoneNumber}", fontSize = 18.sp, color = Color.Black)
            Text(text = "User Type: ${profile.userType}", fontSize = 18.sp, color = Color.Black)
            Text(
                text = "Email Verified: ${profile.email_verified}",
                fontSize = 18.sp,
                color = Color.Black
            )
        } ?: run {
            Text(text = "Загрузка профиля...", fontSize = 18.sp, color = Color.Gray)
        }
    }
}