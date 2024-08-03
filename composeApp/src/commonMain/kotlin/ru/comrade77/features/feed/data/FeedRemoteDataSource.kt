package ru.comrade77.features.feed.data

import ru.comrade77.features.feed.data.models.KtorFeedModel

interface FeedRemoteDataSource {
   suspend fun fecthNextChunk(token: String, postId: String, filters: List<String>): List<KtorFeedModel>
}