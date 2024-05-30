package ru.comrade77.navigation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class MainScreens(val route: String) {
    Home("home"), Subscriptions("subscriptions"), Post("post"), Inbox("inbox"), Library("library")
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController,
            modifier = Modifier.padding(bottom = 56.dp).fillMaxHeight(),
            startDestination = MainScreens.Home.route
        ) {
            composable(MainScreens.Home.route) {}
            composable(MainScreens.Subscriptions.route) {}
            composable(MainScreens.Inbox.route) {}
            composable(MainScreens.Library.route) {}
        }
    }
}
