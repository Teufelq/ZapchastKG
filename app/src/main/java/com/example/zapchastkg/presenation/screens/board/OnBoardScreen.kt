package com.example.zapchastkg110.presenation.screens.board

import android.annotation.SuppressLint
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.example.zapchastkg110.presenation.components.board.OnBoardDesign
import com.example.zapchastkg110.presenation.utils.Screens
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun OnBoardScreen(navHostController: NavHostController) {

    val pagerState = rememberPagerState(initialPage = 0){
            pages.size
        }

    HorizontalPager(state = pagerState) {
        val scope = rememberCoroutineScope()
        OnBoardDesign(
            navHostController,
            page = pages[it],
            pagerState = pagerState.currentPage,
            onClick ={
        scope.launch {
            if (pagerState.currentPage == 2) {
                navHostController.navigate(Screens.ChooseRole.route) {
                    popUpTo(Screens.OnBoardScreen.route) {
                        inclusive = true
                    }
                }
            } else {
                pagerState.animateScrollToPage(
                    page = pagerState.currentPage + 1
                )
                }    }
        },
            onClickSkip = {
                navHostController.navigate(Screens.ChooseRole.route) {
                    popUpTo(Screens.OnBoardScreen.route) {
                        inclusive = true
                    }
                }
            })
          }
     }
