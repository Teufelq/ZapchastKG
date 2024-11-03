package com.example.zapchastkg110.presenation.components.consumer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zapchastkg110.domain.model.auth.RegisterModel
import com.example.zapchastkg110.presenation.components.bases.BaseButton
import com.example.zapchastkg110.presenation.components.bases.BaseText
import com.example.zapchastkg110.presenation.components.bases.BaseTopBar
import com.example.zapchastkg110.presenation.components.bases.SignUpFields
import com.example.zapchastkg110.presenation.screens.auth.signUp.SignUpViewModel
import com.example.zapchastkg110.presenation.ui.theme.Purple
import com.example.zapchastkg110.presenation.utils.Constance
import com.example.zapchastkg110.presenation.utils.Screens


@Composable
fun ConsumerSignUpDesign(
    navController: NavController,
    viewModel: SignUpViewModel,
    onClickEnter: () -> Unit
) {
    val userNameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val phoneNumberState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val passwordStateSecond = remember { mutableStateOf("") }

    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()
    val isRegistered by viewModel.isRegistered.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseTopBar(Constance.consumerSellerSignUpName, Purple)

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignUpFields(
                name = Constance.consumerName,
                color = Purple,
                userNameState = userNameState,
                emailState = emailState,
                phoneNumberState = phoneNumberState,
                passwordState = passwordState,
                passwordState2 = passwordStateSecond
            )

            BaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .width(295.dp),
                shape = RoundedCornerShape(12.dp),
                containerColor = Purple,
                onClick = {
                    val registerModel = RegisterModel(
                        id = 0,
                        username = userNameState.value,
                        password = passwordState.value,
                        email = emailState.value,
                        phone_number = phoneNumberState.value,
                        user_type = "client",
                        email_verified = false
                    )

                    viewModel.registerUser(registerModel, passwordStateSecond.value)
                }
            ) {
                if (loading) {
                    CircularProgressIndicator(color = Color.White, strokeWidth = 2.dp)
                } else {
                    Text("Sign Up", color = Color.White)
                }
            }

            error?.let {
                Text(text = "Error: $it", color = Color.Red)
            }

            if (isRegistered) {
                LaunchedEffect(Unit) {
                    navController.navigate("${Screens.VerifyEmailScreen.route}/${emailState.value}") {
                        popUpTo(Screens.ConsumerSignUpScreen.route) {
                            inclusive = true
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BaseText(text = Constance.alreadyHasAnAccount, fontSize = 16.sp)
                BaseText(
                    text = Constance.enter,
                    fontSize = 16.sp,
                    color = Purple,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable { onClickEnter() }
                )
            }
        }
    }
}