package ru.comrade77.features.feed.domain.models

import ru.comrade77.features.feed.data.models.KtorFeedModel

class Feed(
    val postId: String,
    val title: String,
    val likesCount: Int,
    val repostCount: Int,
    val topics: List<String>,
    val isFavorite: Boolean
)

fun KtorFeedModel.mapToFeed(isFavorite: Boolean): Feed =
    Feed(
        postId,
        title,
        likesCount,
        repostCount,
        topics,
        isFavorite
    )