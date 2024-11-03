package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.zapchastkg110.presenation.ui.theme.Purple
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun SignUpFields(
    name: String,
    color: Color,
    userNameState: MutableState<String>,
    emailState: MutableState<String>,
    phoneNumberState: MutableState<String>,
    passwordState: MutableState<String>,
    passwordState2: MutableState<String>? = null ,
    showFifthField: Boolean = false,
    fifthFieldState: MutableState<String>? = null
) {
        BaseText(text = name)

        BaseEditText(
            values = userNameState.value,
            label = Constance.editTextName,
            placeholder = Constance.labelName,
            onValueChange = { userNameState.value = it },
            color = color,
            leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = "name") }
        )

        BaseEditText(
            values = emailState.value,
            label = Constance.editTextEmail,
            placeholder = Constance.labelEmail,
            onValueChange = { emailState.value = it },
            color = color,
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "name") }
        )

        BaseEditText(
            values = phoneNumberState.value,
            label = Constance.editTextPhone,
            placeholder = Constance.labelPhone,
            onValueChange = {

                    phoneNumberState.value = it

            },
            color = color,
            leadingIcon = { Icon(Icons.Default.Call, contentDescription = "name") }
        )

        BaseEditText(
            values = passwordState.value,
            label = Constance.editTextPassword,
            placeholder = Constance.labelPassword,
            onValueChange = { passwordState.value = it },
            color = color,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "name") }
        )

        BaseEditText(
        values = passwordState2!!.value,
        label = Constance.editTextPassword,
        placeholder = Constance.labelPassword,
        onValueChange = { passwordState2.value = it },
        color = color,
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "name") }
        )

        if (showFifthField && fifthFieldState != null) {
            BaseEditText(
                values = fifthFieldState.value,
                label = Constance.editTextAddress,
                placeholder = Constance.labelAddress,
                onValueChange = { fifthFieldState.value = it },
                color = color,
                leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = "fifth field") }
            )
        }
}
