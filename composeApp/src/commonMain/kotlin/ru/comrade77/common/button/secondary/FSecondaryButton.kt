package ru.comrade77.common.button.secondary

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousTheme

@Composable
fun FSecondaryButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text(text = text, color = FamousTheme.colors.primaryText)
    }
}

@Composable
@Preview
fun FSecondaryButton_Previw() {
    AppTheme {
        FSecondaryButton(text = "Subscribe", onClick = {})
    }
}