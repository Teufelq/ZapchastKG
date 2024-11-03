package com.example.zapchastkg110.presenation.components.seller

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
import com.example.zapchastkg110.presenation.ui.theme.DarkBlue
import com.example.zapchastkg110.presenation.utils.CircularProgressBar
import com.example.zapchastkg110.presenation.utils.Constance
import com.example.zapchastkg110.presenation.utils.Screens


@Composable
fun SellerSignUpDesign(navController: NavController, viewModel: SignUpViewModel, onClickEnter: () -> Unit) {
        val userNameState = remember { mutableStateOf("") }
        val emailState = remember { mutableStateOf("") }
        val phoneNumberState = remember { mutableStateOf("") }
        val passwordState = remember { mutableStateOf("") }
        var passwordStateSecond = remember { mutableStateOf("") }
        val locationState = remember { mutableStateOf("") }

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
        BaseTopBar("Sign Up as Seller", DarkBlue)

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignUpFields(
                name = "Seller Name",
                color = DarkBlue,
                userNameState = userNameState,
                emailState = emailState,
                phoneNumberState = phoneNumberState,
                passwordState = passwordState,
                passwordState2 = passwordStateSecond,
                showFifthField = true,
                fifthFieldState = locationState
            )

            BaseButton(
                modifier = Modifier
                    .height(48.dp)
                    .width(295.dp),
                shape = RoundedCornerShape(12.dp),
                containerColor = DarkBlue,
                onClick = {
                    val registerModel = RegisterModel(
                        id = 0,
                        username = userNameState.value,
                        password = passwordState.value,
                        email = emailState.value,
                        phone_number = phoneNumberState.value,
                        user_type = "seller",
                        email_verified = false
                    )

                    viewModel.registerUser(
                        registerModel,
                        passwordStateSecond.value
                    )
                }
            ) {
                if (loading) {
                   CircularProgressBar(percentage = 1f, number = 100)
                } else {
                    Text("Sign Up", color = Color.White)
                }
            }

            error?.let {
                Text(text = "Error: $it", color = Color.Red)
            }

            if (isRegistered) {
                LaunchedEffect(Unit) {
                    navController.navigate("${Screens.VerifyEmailScreen.route}/${emailState.value}"){
                        popUpTo(Screens.SellerSignUpScreen.route){
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
                BaseText(text = "Already have an account?", fontSize = 16.sp)
                BaseText(
                    text = "Enter",
                    fontSize = 16.sp,
                    color = DarkBlue,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable { onClickEnter() }
                )
            }
        }
    }
}