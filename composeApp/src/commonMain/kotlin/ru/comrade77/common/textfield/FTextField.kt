package ru.comrade77.common.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousTheme


@Composable
fun FTextField(
    text: String,
    hint: String = "",
    enabled: Boolean = true,
    onTextChanged: (String) -> Unit,
) {
    TextField(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        placeholder = { Text(text = hint, color = FamousTheme.colors.tintColor, fontSize = 14.sp) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = FamousTheme.colors.secondaryBackground,
            focusedContainerColor = FamousTheme.colors.secondaryBackground,
            disabledContainerColor = FamousTheme.colors.secondaryBackground.copy(alpha = 0.3f),
            focusedTextColor = FamousTheme.colors.tintColor,
            unfocusedTextColor = FamousTheme.colors.tintColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        textStyle = TextStyle(fontSize = 14.sp),
        value = text,
        onValueChange = onTextChanged,
    )
}

@Composable
@Preview
fun FTextField_Preview() {
    AppTheme {
        FTextField(
            text = "login value",
            hint = "Email"
        ) {}
    }
}

@Composable
@Preview
fun FTextField_Disabled_Preview() {
    AppTheme {
        FTextField(
            text = "login value",
            enabled = false,
        ) {}
    }
}