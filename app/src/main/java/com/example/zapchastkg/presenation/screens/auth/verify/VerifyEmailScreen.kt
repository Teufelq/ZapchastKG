package com.example.zapchastkg110.presenation.screens.auth.verify

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zapchastkg110.presenation.utils.Screens

@Composable
fun VerifyEmailScreen(
    navController: NavController,
    email: String,
    viewModel: VerifyViewModel = hiltViewModel()
) {
    var verificationCode by remember { mutableStateOf("") }
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()
    val isVerified by viewModel.isVerified.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Введите код подтверждения для $email")

        TextField(
            value = verificationCode,
            onValueChange = { verificationCode = it },
            label = { Text("Verification Code") }
        )

        Button(
            onClick = {
                viewModel.verifyEmail(email, verificationCode)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            if (loading) {
                CircularProgressIndicator(color = Color.White, strokeWidth = 2.dp)
            } else {
                Text("Verify Email")
            }
        }

        error?.let {
            Text("Ошибка: $it", color = Color.Red, modifier = Modifier.padding(top = 8.dp))
        }

        if (isVerified) {
            LaunchedEffect(Unit) {
                navController.navigate(Screens.BottomNavBar.route) {
                    popUpTo(Screens.VerifyEmailScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
    }
}