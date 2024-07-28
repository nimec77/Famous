package ru.comrade77.features.feed.models

sealed class FeedEvent {
    class PostClicked(val postId: String): FeedEvent()
    class FilterdClicked(val filterId: String): FeedEvent()
    data object UserClicked: FeedEvent()
    data object LoadMore: FeedEvent()
}
