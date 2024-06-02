package ru.comrade77.common.button.secondary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousTheme

@Composable
fun FSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = FamousTheme.colors.secondaryBackground,
            disabledContainerColor = FamousTheme.colors.secondaryBackground,
        ),
        shape = RoundedCornerShape(12.dp),
        enabled = enabled,
        onClick = onClick,
    ) {
        Text(
            text = text,
            color = if (enabled) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
@Preview
fun FSecondaryButton_Previw() {
    AppTheme {
        Column {
            FSecondaryButton(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                text = "Enabled",
                onClick = {},
            )
            FSecondaryButton(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                text = "Disabled",
                enabled = false,
                onClick = {},
            )
    }
    }
}