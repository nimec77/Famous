package ru.comrade77.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable() () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalFamousColor provides darkPalette,
        content = content
    )
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
