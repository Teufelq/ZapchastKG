package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg.R
import com.example.zapchastkg110.presenation.ui.theme.Purple

@Composable
fun ProfileBtn(text : String, icon: Int, height: Dp = 46.dp, width: Dp = 341.dp, color: Color = Color.White, tintColor: Color = Color.White, fontSize: TextUnit = 18.sp){
    BaseButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(height)
            .width(width),
        shape = RoundedCornerShape(8.dp),
        containerColor = Purple
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            BaseIcon(paint = icon, tintColor = tintColor, Modifier.padding(start = 8.dp))
            BaseText(text = text, color = color, fontSize = fontSize)
            BaseIcon(paint = R.drawable.baseline_navigate_next_24, tintColor = Color.White, Modifier.padding(top = 12.dp))
        }

    }
}
