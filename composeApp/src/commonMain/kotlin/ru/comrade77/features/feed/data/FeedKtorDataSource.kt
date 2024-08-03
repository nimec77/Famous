package ru.comrade77.features.feed.data

import ru.comrade77.core.network.DemoHttpClient
import ru.comrade77.features.feed.data.models.KtorFeedModel

class FeedKtorDataSource(
    private val httpClient: DemoHttpClient = DemoHttpClient()    
): FeedRemoteDataSource {
    override suspend fun fecthNextChunk(token: String, postId: String, filters: List<String>): List<KtorFeedModel> {
        return emptyList()
    }

}
