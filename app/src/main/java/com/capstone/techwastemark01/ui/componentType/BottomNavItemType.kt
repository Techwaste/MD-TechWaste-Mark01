package com.capstone.techwastemark01.ui.componentType

import com.capstone.techwastemark01.R

sealed class BottomNavItemType(val title: String, val icon: Int) {
    object Home: BottomNavItemType(title = "Home", icon = R.drawable.ic_home)
    object Forum: BottomNavItemType(title = "Forum", icon = R.drawable.ic_forum)
    object Article: BottomNavItemType(title = "Article", icon = R.drawable.ic_article)
    object Profile: BottomNavItemType(title = "Profile", icon = R.drawable.ic_account)
}
