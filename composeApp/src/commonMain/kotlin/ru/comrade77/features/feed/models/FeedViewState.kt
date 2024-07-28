package ru.comrade77.features.feed.models

data class FeedViewState(
    val feed: List<String>,
    val filteredFeed: List<String>,
    val filters: List<String>
)