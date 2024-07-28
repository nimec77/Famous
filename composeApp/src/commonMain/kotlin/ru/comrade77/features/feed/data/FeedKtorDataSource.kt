package ru.comrade77.features.feed.data

import ru.comrade77.core.network.DemoHttpClient

class FeedKtorDataSource(
    private val httpClient: DemoHttpClient = DemoHttpClient()    
): FeedRemoteDataSource {
    override suspend fun fecthNextChunk(token: String, postId: String, filters: List<String>): List<String> {
        TODO("Not yet implemented")
    }

}
