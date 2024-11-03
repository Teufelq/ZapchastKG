package com.example.zapchastkg110.presenation.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg110.presenation.components.bases.BaseButton
import com.example.zapchastkg110.presenation.components.bases.BaseSpace
import com.example.zapchastkg110.presenation.components.bases.BaseText
import com.example.zapchastkg110.presenation.screens.auth.login.SignInViewModel
import com.example.zapchastkg110.presenation.ui.theme.DarkBlue
import com.example.zapchastkg110.presenation.utils.CircularProgressBar
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun LoginButtons(
    viewModel: SignInViewModel,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    onClickSignUp: () -> Unit,
) {

    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()
    val isLogined by viewModel.isLogined.collectAsState()

    BaseButton(
        modifier = Modifier
            .height(48.dp)
            .width(295.dp),
        shape = RoundedCornerShape(12.dp),
        containerColor = DarkBlue,
        onClick = {
            viewModel.loginUser(emailState.value, passwordState.value)
        }
    ) {
        if (loading == true) {
            CircularProgressBar(percentage = 1f, number = 100)
        }else BaseText(text = "Войти", fontSize = 20.sp, color = Color.White)

        error?.let {
            Text("Ошибка: $it", color = Color.Red)
        }

        LaunchedEffect(isLogined) {
            if (isLogined == true) {
                onClickSignUp()
            }
        }
    }

    BaseSpace(dp = 12.dp)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BaseText(text = Constance.dontHaveAnAccount, fontSize = 16.sp)
        BaseText(
            text = Constance.registr,
            fontSize = 16.sp,
            color = DarkBlue,
            modifier = Modifier
                .padding(start = 10.dp)
                .clickable { }
        )
    }

    BaseSpace(dp = 12.dp)

}