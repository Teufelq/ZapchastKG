@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zapchastkg110.presenation.components.bases

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapchastkg.R

import com.example.zapchastkg110.presenation.ui.theme.DarkBlue
import com.example.zapchastkg110.presenation.ui.theme.Purple
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun BaseSearchField(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items =
        remember { mutableStateListOf("Насос Лексуса GX470", "Оригинальный Руль Лексуса GX470") }

    val searchBarWidth by animateOffsetAsState(
        targetValue = if (active) Offset(1f, 0f) else Offset(0.94f, 0f),
        animationSpec = tween(durationMillis = 300), label = ""
    )

    Row(modifier = Modifier.fillMaxWidth(searchBarWidth.x),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround){
        SearchBar(
            modifier = modifier
                .fillMaxWidth(0.79f),
            colors = SearchBarDefaults.colors(Color.White),
            shadowElevation = 16.dp,
                shape = RoundedCornerShape(20.dp),
            query = text,
            onQueryChange = { text = it },
            onSearch = {
                items.add(text)
                active = false
                text = ""
            },
            active = active,
            onActiveChange = { active = it },
            placeholder = { BaseText(text = Constance.SearchScreenName) },
            leadingIcon = { BaseIcon(paint = R.drawable.baseline_search_24, tintColor = DarkBlue) },
            trailingIcon = {
                if (active) {
                    BaseIcon(
                        paint = R.drawable.baseline_close_24,
                        tintColor = DarkBlue,
                        modifier = Modifier.clickable {
                            if (text.isNotBlank()) {
                                text = ""
                            } else {
                                active = false
                            }
                        })
                }
            }
        ) {
            items.forEach {
                Row(modifier = Modifier.padding(all = 14.dp)) {
                    BaseIcon(
                        paint = R.drawable.baseline_history_24,
                        tintColor = DarkBlue,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    BaseText(text = it, fontSize = 14.sp)
                }

            }
        }
        if (!active) {
            BaseButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp),
                shape = RoundedCornerShape(20.dp),
                containerColor = Purple,
            ) {
                BaseIcon(paint = R.drawable.menu, tintColor = Color.White)
            }
        }
    }
}