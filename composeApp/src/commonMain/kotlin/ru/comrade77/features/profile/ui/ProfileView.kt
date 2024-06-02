package ru.comrade77.features.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import famous.composeapp.generated.resources.Res
import famous.composeapp.generated.resources.profile_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.features.profile.presentation.models.ProfileEvent
import ru.comrade77.features.profile.presentation.models.ProfileViewState
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousTheme

@Composable
fun ProfileView(
    viewState: ProfileViewState,
    eventHandler: (ProfileEvent) -> Unit,
) {
    Column {
        Box(
            modifier = Modifier.fillMaxWidth().height(72.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(Res.string.profile_title),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = FamousTheme.colors.primaryText,
            )
        }

        Box(
            modifier = Modifier
                .padding(16.dp)
                .clip(CircleShape)
                .size(128.dp)
                .background(Color.White)
        )

        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = viewState.name,
                color = FamousTheme.colors.primaryText,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = viewState.subscribers, color = FamousTheme.colors.tintColor, fontSize = 16.sp)
            Text(text = viewState.joinedIn, color = FamousTheme.colors.tintColor, fontSize = 16.sp)
        }
    }
}

@Composable
@Preview
fun ProfileView_Preview() {
    AppTheme {
        ProfileView(
            viewState = ProfileViewState(
                name = "Natalie",
                subscribers = "5.3m subscribers",
                joinedIn = "Joined in 2017",
            )
        ) {}
    }
}