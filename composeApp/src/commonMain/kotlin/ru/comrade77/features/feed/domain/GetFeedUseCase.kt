package ru.comrade77.features.feed.domain

import ru.comrade77.features.favorite.data.FavoriteLocatDataSource
import ru.comrade77.features.favorite.data.FavoriteRoomDataSource
import ru.comrade77.features.feed.data.FeedKtorDataSource
import ru.comrade77.features.feed.data.FeedRemoteDataSource
import ru.comrade77.features.login.data.AuthEncryptedDataSource
import ru.comrade77.features.login.data.AuthLocalDataSource

class GetFeedUseCase(
    private val autchLocalDataSource: AuthLocalDataSource = AuthEncryptedDataSource(),
    private val favoriteLocatDataSource: FavoriteLocatDataSource = FavoriteRoomDataSource(),
    private val feedRemoteDataSource: FeedRemoteDataSource = FeedKtorDataSource()
) {
    suspend fun excecute(isFavorite: Boolean): List<String> {
        val token = autchLocalDataSource.checkToken()
        val feed =  feedRemoteDataSource.fecthNextChunk(token = token, postId = "", filters = emptyList())
        val favorites = favoriteLocatDataSource.getFavoritePosts()
        return if (isFavorite) feed.filter { favorites.contains(it) } else feed
    }
}