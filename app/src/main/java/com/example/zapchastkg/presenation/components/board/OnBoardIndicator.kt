package com.example.zapchastkg110.presenation.components.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = Color(0xFFFF5C00),
    unselectedColor: Color = Color.Gray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageSize) { pageIndex ->
            Box(
                modifier = Modifier
                    .height(6.dp)
                    .width(if (pageIndex == selectedPage) 30.dp else 18.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(if (pageIndex == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}