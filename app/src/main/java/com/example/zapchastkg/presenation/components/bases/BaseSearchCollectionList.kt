package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg110.domain.model.SearchingItems
import com.example.zapchastkg110.presenation.ui.theme.Purple

@Composable
fun BaseSearchCollectionList(searchingItems: SearchingItems) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.White)
            .border(1.dp, Color.Black)
            .clickable { /* Handle click */ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BaseText(
                text = searchingItems.name,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp))
            BaseIcon(paint = searchingItems.icon, tintColor = Purple, modifier = Modifier.size(46.dp))
        }
}
}