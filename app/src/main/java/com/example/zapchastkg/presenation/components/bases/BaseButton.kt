package com.example.zapchastkg110.presenation.components.bases

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.zapchastkg110.presenation.ui.theme.Orange

@Composable
fun BaseButton(
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.size(50.dp),
    containerColor: Color = Orange,
    shape: Shape = CircleShape,
    borderColor: Color? = null,
    elevation: Dp = 0.dp,
    onClick: () -> Unit,
    content: @Composable () -> Unit,

    ) {
    Button(
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        modifier = modifier
            .then(
                if (borderColor != null) Modifier.border(
                    width = 1.dp,
                    color = borderColor,
                    shape = shape
                ) else Modifier
            )
            .shadow(elevation = elevation, shape = shape),
        contentPadding = PaddingValues(0.dp)
    ) {
        content()
    }
}
