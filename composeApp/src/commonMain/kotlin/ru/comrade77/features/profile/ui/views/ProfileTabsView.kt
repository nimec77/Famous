package ru.comrade77.features.profile.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousColors
import ru.comrade77.theme.FamousTheme

@Composable
fun ProfileTabsView(
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
) {
    Column(modifier = Modifier.height(54.dp)) {
        Row(modifier = Modifier.fillMaxHeight()) {
            items.forEach {
                val index = items.indexOf(it)
                Spacer(modifier = Modifier.width(16.dp))
                ProfileTab(
                    title = it,
                    isSelected = selectedIndex == index
                ) {
                    onItemSelected.invoke(index)
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = FamousTheme.colors.dividerColor,
        )
    }
}

@Composable
internal fun ProfileTab(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable { onClick.invoke() }
            .width(IntrinsicSize.Max).fillMaxHeight()
    )
    {
        Text(
            modifier = Modifier.width(IntrinsicSize.Max).align(Alignment.Center),
            text = title,
            textAlign = TextAlign.Center,
            color = if (isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor,
        )
        
        Divider(
            modifier = Modifier.height(3.dp).align(Alignment.BottomStart),
            color = if (isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor
        )
}
}

@Composable
@Preview
fun ProfileTabsView_Preview() {
    AppTheme {
        ProfileTabsView(
            items = listOf("Videos", "Playlists", "About"),
            selectedIndex = 0,
        ) {}
    }
}