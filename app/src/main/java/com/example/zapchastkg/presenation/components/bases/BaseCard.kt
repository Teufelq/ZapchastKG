package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg110.domain.model.GeneralScrollViewItems
import com.example.zapchastkg110.presenation.ui.theme.Gray

@Composable
fun BaseCard(color: Color, generalScrollViewItems: GeneralScrollViewItems) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Gray
        ),
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = { /* Do something */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            BaseImage(painter = painterResource(id = generalScrollViewItems.img),
                contentDescription = "Main Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White),
                contentScale = ContentScale.Crop)
            BaseText( text = generalScrollViewItems.name, fontSize = 18.sp)
            BaseText(text = generalScrollViewItems.title, fontSize = 18.sp,)
            BaseText(text = generalScrollViewItems.category, fontSize = 16.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            BaseText(text = generalScrollViewItems.description, fontSize = 12.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BaseText(  text = generalScrollViewItems.price.toString(), fontSize = 16.sp, color = color)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BaseIcon(generalScrollViewItems.iconViewers, modifier = Modifier.size(22.dp), tintColor = color)
                    Spacer(modifier = Modifier.width(4.dp))
                    BaseText(text = generalScrollViewItems.quantityOfViewers.toString(), fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    BaseIcon( generalScrollViewItems.iconChat, modifier = Modifier.size(22.dp), tintColor = color)
                    Spacer(modifier = Modifier.width(4.dp))
                    BaseText(text = generalScrollViewItems.quantityOfChatMembers.toString(), fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    BaseIcon(generalScrollViewItems.iconLike, modifier = Modifier.size(22.dp), tintColor = Color.LightGray)
                    Spacer(modifier = Modifier.width(4.dp))
                    BaseText(text = generalScrollViewItems.quantityOfLikes.toString(), fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    BaseIcon(generalScrollViewItems.iconTime, modifier = Modifier.size(22.dp), tintColor = color)
                    Spacer(modifier = Modifier.width(4.dp))
                    BaseText(text = generalScrollViewItems.timeOfAdded.toString(), fontSize = 18.sp)
                }
            }
        }
    }
}