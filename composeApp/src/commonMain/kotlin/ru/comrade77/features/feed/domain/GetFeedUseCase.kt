package ru.comrade77.features.feed.domain

import ru.comrade77.features.favorite.data.FavoriteLocatDataSource
import ru.comrade77.features.favorite.data.FavoriteRoomDataSource
import ru.comrade77.features.feed.data.FeedKtorDataSource
import ru.comrade77.features.feed.data.FeedRemoteDataSource
import ru.comrade77.features.feed.domain.models.Feed
import ru.comrade77.features.feed.domain.models.mapToFeed
import ru.comrade77.features.login.data.AuthEncryptedDataSource
import ru.comrade77.features.login.data.AuthLocalDataSource

class GetFeedUseCase(
    private val autchLocalDataSource: AuthLocalDataSource = AuthEncryptedDataSource(),
    private val favoriteLocatDataSource: FavoriteLocatDataSource = FavoriteRoomDataSource(),
    private val feedRemoteDataSource: FeedRemoteDataSource = FeedKtorDataSource()
) {
    suspend fun excecute(): List<Feed> {
        val token = autchLocalDataSource.checkToken()
        val favorites = favoriteLocatDataSource.getFavoritePosts()
        val feed =  feedRemoteDataSource.fecthNextChunk(token = token, postId = "", filters = emptyList())
            .map { it.mapToFeed(isFavorite = favorites.contains(it.postId))}
        return feed
    }
}