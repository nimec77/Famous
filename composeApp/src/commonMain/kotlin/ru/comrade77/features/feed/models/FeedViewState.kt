package ru.comrade77.features.feed.models

import ru.comrade77.features.feed.presentation.views.FeedCellModel

data class FeedViewState(
    val feed: List<FeedCellModel> = emptyList(),
    val filters: List<String> = emptyList()
)