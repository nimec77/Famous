package ru.comrade77.features.feed

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.comrade77.base.BaseViewModel
import ru.comrade77.features.feed.domain.GetFeedUseCase
import ru.comrade77.features.feed.models.FeedAction
import ru.comrade77.features.feed.models.FeedEvent
import ru.comrade77.features.feed.models.FeedViewState
import ru.comrade77.features.feed.presentation.views.FeedCellModel

class FeedViewModel() : BaseViewModel<FeedViewState, FeedAction, FeedEvent>(initialState = FeedViewState(feed = emptyList(), filters = emptyList())) {
    private val getFeedUseCase = GetFeedUseCase()

    init {
        loadScreen()
    }

    override fun obtainEvent(viewEvent: FeedEvent) {
        when(viewEvent) {
            is FeedEvent.FilterdClicked -> filterContent(viewEvent.filterId)
            is FeedEvent.PostClicked -> obtainPostClick(viewEvent.postId)
            FeedEvent.UserClicked -> showUserProfile()
            FeedEvent.LoadMore -> loadMoreFeed()
        }
    }

    private fun loadScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            val feed = getFeedUseCase.excecute()
                .map {
                    FeedCellModel(
                        postId = it.postId,
                        imageUrl = "",
                        title = it.title,
                        category = it.topics.joinToString(separator = ","),
                        socialInfo = "${it.likesCount}  likes / ${it.repostCount} repost",
                        hasBlur = it.postId == "1"
                    )
                }

            withContext(Dispatchers.Main) {
                viewState = viewState.copy(
                    feed = feed
                )
            }
        }
    }

    private fun filterContent(filterId: String) {}
    
    private fun obtainPostClick(postId: String) {}
    
    private fun showUserProfile() {
        
    }
    
    private fun loadMoreFeed() {
        
    }
}