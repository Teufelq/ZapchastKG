package com.example.zapchastkg110.presenation.components.forgot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg110.presenation.components.bases.BaseButton
import com.example.zapchastkg110.presenation.components.bases.BaseText
import com.example.zapchastkg110.presenation.components.bases.BaseTopBar
import com.example.zapchastkg110.presenation.ui.theme.DarkBlue
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun RecoveryPasswordDesign(){
    val otpVal: String? = null
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
                .fillMaxHeight(0.7f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        BaseText(text = Constance.attentionTitle)
        BaseText(text = Constance.attentionDescription, fontSize = 18.sp)
        BaseText(text = Constance.attentionCode, fontSize = 18.sp, modifier = Modifier.align(Alignment.Start))
        OTPTextFields(
            length = 5
        ) {
                getOpt -> otpVal
        }
        BaseButton(modifier = Modifier
            .height(48.dp)
            .width(295.dp),
            shape = RoundedCornerShape(12.dp),
            containerColor = DarkBlue,
            onClick = {}) {
            BaseText(text = Constance.verify, fontSize = 20.sp, color = Color.White)
        }
    }
    }
}

