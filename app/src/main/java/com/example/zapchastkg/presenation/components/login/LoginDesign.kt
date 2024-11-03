package com.example.zapchastkg110.presenation.components.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg.R
import com.example.zapchastkg110.presenation.components.bases.BaseEditText
import com.example.zapchastkg110.presenation.components.bases.BaseImage
import com.example.zapchastkg110.presenation.components.bases.BaseSpace
import com.example.zapchastkg110.presenation.components.bases.BaseText
import com.example.zapchastkg110.presenation.components.bases.BaseTopBar
import com.example.zapchastkg110.presenation.screens.auth.login.SignInViewModel
import com.example.zapchastkg110.presenation.ui.theme.DarkBlue
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun SignInDesign(viewModel: SignInViewModel, onClickSignUp:() -> Unit, onClickForgotPassword:() -> Unit) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseTopBar(Constance.loginScreenName, DarkBlue)
        Column(
            modifier = Modifier
                .fillMaxWidth(0.93f)
                .padding(top = 16.dp)
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseImage(
                painter = painterResource(id = R.drawable.signinimg),
                modifier = Modifier.size(298.dp)
            )
            BaseEditText(
                values = emailState.value,
                label = Constance.editTextEmailOrPhone,
                placeholder = Constance.labelEmailOrPhone,
                onValueChange = { emailState.value = it },
                leadingIcon = { Icon(Icons.Default.MailOutline, contentDescription = "name") },
                color = DarkBlue
            )
            BaseEditText(
                values = passwordState.value,
                label = Constance.editTextPassword,
                placeholder = Constance.labelSignInPassword,
                onValueChange = { passwordState.value = it },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "phoneNumber") },
                color = DarkBlue
            )
            BaseSpace(dp = 12.dp)
            BaseText(
                text = Constance.forgotPassword,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 20.dp)
                    .clickable { onClickForgotPassword() }
            )
            BaseSpace(dp = 12.dp)
            LoginButtons(viewModel, emailState, passwordState) { onClickSignUp() }
        }
    }
}