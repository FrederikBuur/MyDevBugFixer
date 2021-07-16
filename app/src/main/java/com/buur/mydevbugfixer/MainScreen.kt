package com.buur.mydevbugfixer

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.buur.mydevbugfixer.favorites.FavoriteArticlesScreen
import com.buur.mydevbugfixer.search.SearchArticlesScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = listOf(Screen.Search, Screen.Favorites)
            )
        }
    ) {
        MainScreenNavigationConfiguration(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, items: List<Screen>) {
    var currentRoute by remember {
        mutableStateOf(items.first().route)
    }
    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title
                    )
                },
                label = { Text(text = screen.title) },
                alwaysShowLabel = false,
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        currentRoute = screen.route
                        navController.navigate(screen.route)
                    }
                }
            )
        }

    }
}

@Composable
fun MainScreenNavigationConfiguration(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Search.route
    ) {
        composable(route = Screen.Search.route) {
            SearchArticlesScreen(navController = navController)
        }
        composable(route = Screen.Favorites.route) {
            FavoriteArticlesScreen(navController = navController)
        }
    }
}
