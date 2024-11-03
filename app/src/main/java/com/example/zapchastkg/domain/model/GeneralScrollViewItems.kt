package com.example.zapchastkg110.domain.model

import com.example.zapchastkg.R

data class GeneralScrollViewItems(
    val img : Int,
    val name : String,
    val title : String,
    val category: String,
    val description : String,
    val price: String,
    val iconViewers: Int = R.drawable.baseline_remove_red_eye_24,
    val quantityOfViewers : Int,
    val iconChat : Int = R.drawable.baseline_chat_24,
    val quantityOfChatMembers : Int,
    val iconLike: Int = R.drawable.baseline_favorite_24,
    val quantityOfLikes : Int,
    val iconTime : Int = R.drawable.baseline_access_time_24,
    val timeOfAdded : String
 )

val navItems = listOf(
    GeneralScrollViewItems(
        img = R.drawable.imgmain,
        name = "РУЛЬ ЛЕКСУСА GX470 2009Г. ",
        title = "НОВЫЙРУЛЬ ЛЕКСУСА GX470 2009Г. ",
        category = "КАТЕГОРИЯ:  РУЛЕВЫЕ ЗАПЧАСТИ",
        description = "Левый руль. Контрактный, без пробега по КР. Lexus GX470 1 поколение (01.2002 - 07.2009) Гарантия...",
        price = "7 000c",
        quantityOfViewers = 21,
        quantityOfChatMembers = 12,
        quantityOfLikes = 431,
        timeOfAdded = "4ч.н."
    ),
    GeneralScrollViewItems(
        img = R.drawable.imgmain,
        name = "РУЛЬ ЛЕКСУСА GX470 2009Г. ",
        title = "НОВЫЙРУЛЬ ЛЕКСУСА GX470 2009Г. ",
        category = "КАТЕГОРИЯ:  РУЛЕВЫЕ ЗАПЧАСТИ",
        description = "Левый руль. Контрактный, без пробега по КР. Lexus GX470 1 поколение (01.2002 - 07.2009) Гарантия...",
        price = "7 000c",
        quantityOfViewers = 21,
        quantityOfChatMembers = 12,
        quantityOfLikes = 431,
        timeOfAdded = "4ч.н."
    ),
    GeneralScrollViewItems(
        img = R.drawable.imgmain,
        name = "РУЛЬ ЛЕКСУСА GX470 2009Г. ",
        title = "НОВЫЙРУЛЬ ЛЕКСУСА GX470 2009Г. ",
        category = "КАТЕГОРИЯ:  РУЛЕВЫЕ ЗАПЧАСТИ",
        description = "Левый руль. Контрактный, без пробега по КР. Lexus GX470 1 поколение (01.2002 - 07.2009) Гарантия...",
        price = "7 000c",
        quantityOfViewers = 21,
        quantityOfChatMembers = 12,
        quantityOfLikes = 431,
        timeOfAdded = "4ч.н."
    )
)