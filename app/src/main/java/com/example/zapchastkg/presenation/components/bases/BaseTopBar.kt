package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BaseTopBar(text: String, color: Color, modifier: Modifier = Modifier, textModifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color)
    ) {
        BaseText(
            text = text,
            modifier = textModifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 14.dp),
            color = Color.White,
        )
    }
}