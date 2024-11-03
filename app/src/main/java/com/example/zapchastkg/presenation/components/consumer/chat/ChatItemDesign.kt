package com.example.zapchastkg110.presenation.components.consumer.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg110.domain.model.ChatsItem
import com.example.zapchastkg110.presenation.components.bases.BaseImage
import com.example.zapchastkg110.presenation.components.bases.BaseText

@Composable
fun ChatItemDesign(chatsItem: ChatsItem) {
    Row(Modifier
        .fillMaxWidth().padding(bottom = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
        ){
        BaseImage(
            painter = painterResource(id = chatsItem.avatar),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(Modifier
            .fillMaxWidth(0.8f).padding(start = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
            ){
            BaseText(text = chatsItem.name)
            BaseText(text = chatsItem.lastMessage, fontSize = 18.sp)
        }
        BaseText(text = chatsItem.time, fontSize = 16.sp, color = Color.Gray)
    }
}