@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zapchastkg110.presenation.components.consumer.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.zapchastkg110.domain.model.searchingItem
import com.example.zapchastkg110.presenation.components.bases.BaseSearchCollectionList
import com.example.zapchastkg110.presenation.components.bases.BaseSearchField
import com.example.zapchastkg110.presenation.components.bases.BaseSpace
import com.example.zapchastkg110.presenation.components.bases.BaseTopBar
import com.example.zapchastkg110.presenation.ui.theme.Purple
import com.example.zapchastkg110.presenation.utils.Constance

@Composable
fun SearchConsumerDesign(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseTopBar(Constance.SearchScreenName, Purple)
        Column(modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight()
            .padding(top = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseSearchField()
            BaseSpace(dp = 12.dp)
            LazyColumn(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
            ) {
                items(searchingItem){ NAV->
                   BaseSearchCollectionList(searchingItems = NAV)

                }
            }
        }
    }
}