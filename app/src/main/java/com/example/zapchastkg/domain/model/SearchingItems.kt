package com.example.zapchastkg110.domain.model

import com.example.zapchastkg.R


data class SearchingItems (
    val name: String,
    val icon: Int = R.drawable.baseline_navigate_next_24
)

val searchingItem = listOf(
    SearchingItems("детали для кузова"),
    SearchingItems("двигатель и его детали"),
    SearchingItems("фары и их детали"),
    SearchingItems("кпп и ее детали"),
    SearchingItems("ходовая часть"),
    SearchingItems("детали для кузова"),
    SearchingItems("двигатель и его детали"),
    SearchingItems("фары и их детали"),
    SearchingItems("кпп и ее детали"),
    SearchingItems("ходовая часть"),
    SearchingItems("детали для кузова"),
    SearchingItems("двигатель и его детали"),
    SearchingItems("фары и их детали"),
    SearchingItems("кпп и ее детали"),
    SearchingItems("ходовая часть"),
    SearchingItems("детали для кузова"),
    SearchingItems("двигатель и его детали"),
    SearchingItems("фары и их детали"),
    SearchingItems("кпп и ее детали"),
    SearchingItems("ходовая часть"),
)