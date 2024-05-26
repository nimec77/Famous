package ru.comrade77.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.staticCompositionLocalOf


data class FamousColors (
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val deviderColor: Color,
)

object FamousTheme {
    val colors: FamousColors
        @Composable
        get() = LocalFamousColor.current
}
val LocalFamousColor = staticCompositionLocalOf<FamousColors> {error("Np default implementation for colors") }
