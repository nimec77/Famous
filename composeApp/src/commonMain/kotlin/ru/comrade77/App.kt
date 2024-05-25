package ru.comrade77

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.comrade77.features.create.CreatePost
import ru.comrade77.features.login.LoginScreen
import ru.comrade77.features.paywall.PaywallScreen
import ru.comrade77.navigation.AppScreens
import ru.comrade77.navigation.LocalNavHost
import ru.comrade77.navigation.main.MainScreen
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousColors
import ru.comrade77.theme.FamousTheme

@Composable
internal fun App() = AppTheme {
    Box(modifier = Modifier.fillMaxSize().background(FamousTheme.colors.primaryBackground)) {
        FamousApp()
    }
}


@Composable
internal fun FamousApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login.title

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = currentScreen
        ) {
            composable(route = AppScreens.Login.title) {
                LoginScreen()
            }

            composable(route = AppScreens.Main.title) {
                MainScreen()
            }

            composable(route = AppScreens.CreatePost.title) {
                CreatePost()
            }

            composable(route = AppScreens.Paywall.title) {
                PaywallScreen()
            }
        }
    }
}

internal expect fun openUrl(url: String?)