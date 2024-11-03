package com.example.zapchastkg110.domain.model

import com.example.zapchastkg.R


data class ChatsItem(
    val avatar : Int,
    val name : String,
    val lastMessage : String,
    val time : String
)

val chatList = listOf(
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56"),
    ChatsItem(R.drawable.gogush, "Gogush", "товар кана жетим", "7.56")
)