package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg110.presenation.ui.theme.Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseEditText(
    modifier: Modifier = Modifier
        .padding(horizontal = 18.dp, vertical = 4.dp)
        .fillMaxWidth(),
    values: String,
    label: String? = null,
    placeholder: String? = null,
    color: Color,
    colorIndicator: Color = Color.White, // Добавил для индикатора
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = values,
        onValueChange = onValueChange,
        label = {
            if (!label.isNullOrEmpty()) {
                BaseText(text = label, fontSize = 16.sp)
            }
        },
        placeholder = {
            if (!placeholder.isNullOrEmpty()) {
                BaseText(text = placeholder, fontSize = 16.sp)
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = color,
            unfocusedIndicatorColor = colorIndicator,
            focusedIndicatorColor = colorIndicator,
            focusedLabelColor = color,
            unfocusedLabelColor = Color.Black,
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    )
}