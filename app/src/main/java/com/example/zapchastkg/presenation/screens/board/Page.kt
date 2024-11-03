package com.example.zapchastkg110.presenation.screens.board

import androidx.annotation.DrawableRes
import com.example.zapchastkg.R
import com.example.zapchastkg110.presenation.utils.Constance

data class Page(
    val title: String,
    val description : String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(title = Constance.boardTitle1, description = Constance.boardDescription1, image = R.drawable.boardimg1),
    Page(title = Constance.boardTitle2, description = Constance.boardDescription2, image = R.drawable.boardimg2),
    Page(title = Constance.boardTitle3, description = Constance.boardDescription3, image = R.drawable.boardimg3)
)