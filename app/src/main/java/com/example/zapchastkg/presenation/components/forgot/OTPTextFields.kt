package com.example.zapchastkg110.presenation.components.forgot

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.zapchastkg110.presenation.components.bases.BaseEditText


@Composable
fun OTPTextFields(
    modifier: Modifier = Modifier,
    length: Int,
    onFilled: (code: String) -> Unit
) {
    var code: MutableList<Char?> by remember { mutableStateOf(MutableList(length) { null }) }
    val focusRequesters: List<FocusRequester> = remember {
        List(length) { FocusRequester() }
    }

    Row(
        modifier = modifier.height(50.dp)
    ) {
        (0 until length).forEach { index ->
            OutlinedTextField(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .focusRequester(focusRequesters[index])
                    .onKeyEvent { event ->
                        if (event.nativeKeyEvent.keyCode == android.view.KeyEvent.KEYCODE_DEL) {
                            if (code[index] != null) {
                                code = code.toMutableList().apply { this[index] = null }
                            } else if (index > 0) {
                                focusRequesters[index - 1].requestFocus()
                            }
                            return@onKeyEvent true
                        }
                        false
                    },
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = Color.Black
                ),
                singleLine = true,
                value = code[index]?.toString() ?: "",
                onValueChange = { value: String ->
                    if (value.isNotEmpty() && value[0].isDigit()) {
                        val temp = code.toMutableList()
                        temp[index] = value[0]
                        code = temp
                        if (index < length - 1) {
                            focusRequesters[index + 1].requestFocus()
                        } else {
                            onFilled(code.filterNotNull().joinToString(""))
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = if (index == length - 1) ImeAction.Done else ImeAction.Next
                ),
                visualTransformation = VisualTransformation.None
            )

            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}
