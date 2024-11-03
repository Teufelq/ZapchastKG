package com.example.zapchastkg110.presenation.components.consumer.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg.R
import com.example.zapchastkg110.presenation.components.bases.ProfileBtn
import com.example.zapchastkg110.presenation.ui.theme.FavBlue
import com.example.zapchastkg110.presenation.ui.theme.FavRed

@Composable
fun ProfileFooter() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProfileBtn(
            text = "Выйти",
            icon = R.drawable.exit,
            height = 46.dp,
            width = 158.dp,
            color = FavRed,
            tintColor = FavRed
        )

        ProfileBtn(
            text = "Политика конфиденциальности",
            icon = R.drawable.pp,
            height = 46.dp,
            width = 158.dp,
            color = FavBlue,
            tintColor = FavBlue,
            fontSize = 12.sp
        )
    }
}
