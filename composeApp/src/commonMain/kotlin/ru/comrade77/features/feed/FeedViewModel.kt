package ru.comrade77.features.feed

import ru.comrade77.base.BaseViewModel
import ru.comrade77.features.feed.domain.GetFeedUseCase
import ru.comrade77.features.feed.models.FeedAction
import ru.comrade77.features.feed.models.FeedEvent
import ru.comrade77.features.feed.models.FeedViewState

class FeedViewModel() : BaseViewModel<FeedViewState, FeedAction, FeedEvent>(initialState = FeedViewState(feed = emptyList(), filteredFeed = emptyList(), filters = emptyList())) {
    private val getFeedUseCase = GetFeedUseCase()
    override fun obtainEvent(viewEvent: FeedEvent) {
        when(viewEvent) {
            is FeedEvent.FilterdClicked -> filterContent(viewEvent.filterId)
            is FeedEvent.PostClicked -> obtainPostClick(viewEvent.postId)
            FeedEvent.UserClicked -> showUserProfile()
            FeedEvent.LoadMore -> loadMoreFeed()
        }
    }

    private fun filterContent(filterId: String) {}
    
    private fun obtainPostClick(postId: String) {}
    
    private fun showUserProfile() {
        
    }
    
    private fun loadMoreFeed() {
        
    }
}