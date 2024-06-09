package ru.comrade77.features.profile.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import famous.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.common.button.secondary.FSecondaryButton
import ru.comrade77.features.profile.presentation.models.ProfileEvent
import ru.comrade77.features.profile.presentation.models.ProfileViewState
import ru.comrade77.features.profile.ui.views.ProfileAboutView
import ru.comrade77.features.profile.ui.views.ProfilePlaylistsView
import ru.comrade77.features.profile.ui.views.ProfileTabsView
import ru.comrade77.features.profile.ui.views.ProfileVideosView
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileView(
    viewState: ProfileViewState,
    eventHandler: (ProfileEvent) -> Unit
) {
    LazyColumn {
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.profile_title),
                    color = FamousTheme.colors.primaryText,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(64.dp))
                    .size(128.dp)
                    .background(Color.White)
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = viewState.name,
                    color = FamousTheme.colors.primaryText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = viewState.subscribers, color = FamousTheme.colors.tintColor, fontSize = 16.sp)
                Text(text = viewState.joinedIn, color = FamousTheme.colors.tintColor, fontSize = 16.sp)
            }
        }

        if (viewState.isSubscribed != null) {
            item {
                FSecondaryButton(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    text = stringResource(if (viewState.isSubscribed == false) Res.string.profile_subscribe else Res.string.profile_subscribed)
                ) {

                }
            }
        }

        item {
            ProfileTabsView(
                items = listOf(
                    stringResource(Res.string.profile_videos),
                    stringResource(Res.string.profile_playlists),
                    stringResource(Res.string.profile_about)
                ),
                selectedIndex = viewState.selectedTabIndex
            ) {
                eventHandler.invoke(ProfileEvent.TabSelected(it))
            }
        }

        item {
            Box(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                when (viewState.selectedTabIndex) {
                    0 -> ProfileVideosView()
                    1 -> ProfilePlaylistsView()
                    2 -> ProfileAboutView()
                }
            }
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
                isSubscribed = true
            )
        ) {

        }
    }
}
