package com.buur.mydevbugfixer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {

    object Search : Screen("main-screen", "Search", Icons.Rounded.Search)
    object Favorites : Screen("favorites-screen", "Favorites", Icons.Rounded.Star)

}