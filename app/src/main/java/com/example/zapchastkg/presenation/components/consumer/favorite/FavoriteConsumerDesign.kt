package com.example.zapchastkg110.presenation.components.consumer.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zapchastkg110.domain.model.navItems
import com.example.zapchastkg110.presenation.components.bases.BaseCard
import com.example.zapchastkg110.presenation.components.bases.BaseTopBar
import com.example.zapchastkg110.presenation.ui.theme.Purple
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun FavoriteConsumerDesign(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseTopBar(Constance.favScreenName, Purple)
        Column(modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight()
            .padding(top = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.82f)
            ) {
                items(navItems){ NAV->
                    BaseCard(color = Purple, generalScrollViewItems = NAV)

                }
            }
        }
    }
}