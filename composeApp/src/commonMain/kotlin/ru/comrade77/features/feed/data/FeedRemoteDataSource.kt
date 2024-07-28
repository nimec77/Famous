package ru.comrade77.features.feed.data

interface FeedRemoteDataSource {
   suspend fun fecthNextChunk(token: String, postId: String, filters: List<String>): List<String>
}