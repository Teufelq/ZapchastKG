package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun BaseIcon(paint: Int, tintColor: Color, modifier: Modifier = Modifier){
    Icon(
        painter = painterResource(id = paint),
        modifier = modifier,
        contentDescription = "icons",
        tint = tintColor
    )
}