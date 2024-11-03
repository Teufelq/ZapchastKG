package com.example.zapchastkg110.presenation.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.zapchastkg.R
import com.example.zapchastkg110.presenation.screens.consumer.chat.ChatConsumerScreen
import com.example.zapchastkg110.presenation.screens.consumer.favorite.FavoriteScreenConsumer
import com.example.zapchastkg110.presenation.screens.consumer.main.MainConsumerScreen
import com.example.zapchastkg110.presenation.screens.auth.login.profile.ProfileConsumerScreen
import com.example.zapchastkg110.presenation.screens.consumer.search.SearchConsumerScreen
import com.example.zapchastkg110.presenation.ui.theme.Purple

data class NavItem(
    val icon : Int
)

@Composable
fun BottomBar(navHostController: NavHostController) {
    val navItemList = listOf(
        NavItem(icon = R.drawable.baseline_home_filled_24),
        NavItem(icon = R.drawable.baseline_search_24),
        NavItem(icon = R.drawable.baseline_star_24),
        NavItem(icon = R.drawable.baseline_chat_24),
        NavItem(icon = R.drawable.baseline_person_pin_24),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 56.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Purple),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    navItemList.forEachIndexed { index, page ->
                        IconButton(
                            onClick = { selectedIndex = index }
                        ) {
                            Icon(
                                painter = painterResource(id = page.icon),
                                contentDescription = "icons",
                                tint = if (selectedIndex == index) Color.White else Color.LightGray
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex, navHostController)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int, navHostController: NavHostController) {
    when(selectedIndex){
        0-> MainConsumerScreen(navHostController = navHostController)
        1-> SearchConsumerScreen(navHostController = navHostController)
        2-> FavoriteScreenConsumer(navHostController = navHostController)
        3-> ChatConsumerScreen(navHostController)
        4-> ProfileConsumerScreen( navHostController)
    }
}