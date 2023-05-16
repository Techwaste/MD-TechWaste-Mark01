package com.capstone.techwastemark01.ui.componentType

import com.capstone.techwastemark01.R

sealed class ArticleFilterType(val type: String, val icon: Int) {
    object General: ArticleFilterType(type = "General", icon = R.drawable.ic_general)
    object Laptop: ArticleFilterType(type = "Laptop", icon = R.drawable.ic_laptop)
    object Tv: ArticleFilterType(type = "TV", icon = R.drawable.ic_tv)
    object LightBulb: ArticleFilterType(type = "Light Bulb", icon = R.drawable.ic_light_bulb)
    object Battery: ArticleFilterType(type = "Battery", icon = R.drawable.ic_battery)
    object Cable: ArticleFilterType(type = "Cable", icon = R.drawable.ic_cable)

}
