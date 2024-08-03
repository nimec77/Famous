package ru.comrade77.features.feed

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ru.comrade77.features.feed.models.FeedEvent
import ru.comrade77.features.feed.models.FeedViewState
import ru.comrade77.features.feed.presentation.views.FeedCell

@Composable
fun FeedView(viewState: FeedViewState, eventHandler: (FeedEvent) -> Unit) {
    LazyColumn {
        items(viewState.feed) {
            FeedCell(it)
        }
    }
}

