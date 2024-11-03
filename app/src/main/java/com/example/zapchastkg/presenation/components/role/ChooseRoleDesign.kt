package com.example.zapchastkg110.presenation.components.role

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg.R
import com.example.zapchastkg110.presenation.components.bases.BaseButton
import com.example.zapchastkg110.presenation.components.bases.BaseDivider
import com.example.zapchastkg110.presenation.components.bases.BaseImage
import com.example.zapchastkg110.presenation.components.bases.BaseSpace
import com.example.zapchastkg110.presenation.components.bases.BaseText
import com.example.zapchastkg110.presenation.components.bases.BaseTopBar
import com.example.zapchastkg110.presenation.ui.theme.DarkBlue
import com.example.zapchastkg110.presenation.ui.theme.Gray
import com.example.zapchastkg110.presenation.ui.theme.Orange
import com.example.zapchastkg110.presenation.ui.theme.Purple
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun ChooseRoleDesign(onClickSeller:()-> Unit, onClickConsumer:()-> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseTopBar(Constance.chooseRoleName, Orange)
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BaseText(text = Constance.chooseRoleTitle1, color = DarkBlue, fontSize = 20.sp)
                BaseSpace(dp = 12.dp)
                BaseText(
                    text = Constance.chooseRoleDescription1,
                    fontSize = 16.sp
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    BaseImage(
                        painter = painterResource(id = R.drawable.roleselller),
                        contentDescription = "seller",
                        modifier = Modifier
                            .size(140.dp)
                            .align(Alignment.CenterEnd)
                    )
                    BaseButton(modifier = Modifier
                        .height(36.dp)
                        .width(160.dp)
                        .align(Alignment.BottomCenter),
                        shape = RoundedCornerShape(6.dp) ,
                        containerColor = DarkBlue,
                        onClick = { onClickSeller() }) {
                            BaseText(text = "Продолжить", fontSize = 14.sp, color = Color.White)
                    }
                }
            }

            BaseDivider(color = Gray)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BaseText(text = Constance.chooseRoleTitle2, color = Purple, fontSize = 20.sp)
                BaseSpace(dp = 12.dp)
                BaseText(
                    text = Constance.chooseRoleDescription2,
                    fontSize = 16.sp
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    BaseImage(
                        painter = painterResource(id = R.drawable.roleconsumer),
                        contentDescription = "consumer",
                        modifier = Modifier
                            .size(140.dp)
                            .align(Alignment.CenterStart)
                    )
                    BaseButton(modifier = Modifier
                        .height(36.dp)
                        .width(160.dp)
                        .align(Alignment.BottomCenter),
                        shape = RoundedCornerShape(6.dp) ,
                        containerColor = Purple,
                        onClick = { onClickConsumer()}) {
                        BaseText(text = "Продолжить", fontSize = 14.sp, color = Color.White)
                    }
                }
            }
        }
    }
}


