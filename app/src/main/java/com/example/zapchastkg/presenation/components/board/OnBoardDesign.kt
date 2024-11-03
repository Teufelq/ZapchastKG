package com.example.zapchastkg110.presenation.components.board

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.zapchastkg110.presenation.components.bases.BaseButton
import com.example.zapchastkg110.presenation.components.bases.BaseImage
import com.example.zapchastkg110.presenation.components.bases.BaseSpace
import com.example.zapchastkg110.presenation.components.bases.BaseText
import com.example.zapchastkg110.presenation.components.bases.BaseTopBar
import com.example.zapchastkg110.presenation.screens.board.Page
import com.example.zapchastkg110.presenation.screens.board.pages
import com.example.zapchastkg110.presenation.ui.theme.Orange

@Composable
fun OnBoardDesign(
    navHostController: NavHostController,
    page: Page,
    pagerState: Int,
    onClick: () -> Unit,
    onClickSkip: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        BaseTopBar(page.title,Orange)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BaseImage(
                    painter = painterResource(id = page.image),
                    modifier = Modifier.fillMaxWidth().height(400.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                BaseText(
                    text = page.description,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp
                )
            }
            BaseSpace(dp = 20.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BaseText(
                    text = "Skip",
                    modifier = Modifier.clickable { onClickSkip() },
                    fontSize = 18.sp,
                    color = Orange
                )
                OnBoardIndicator(pageSize = pages.size, selectedPage = pagerState)
                BaseButton(onClick = { onClick() }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "forward",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}