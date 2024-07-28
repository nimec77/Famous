package ru.comrade77.features.favorite.data

import ru.comrade77.core.database.AppDatabase
import ru.comrade77.core.di.InjectProvider

interface FavoriteLocatDataSource {
    suspend fun getFavoritePosts(): List<String>
}

class FavoriteRoomDataSource(
    private val database: AppDatabase = InjectProvider.getDatabase() 
): FavoriteLocatDataSource {
    override suspend fun getFavoritePosts(): List<String> {
        return emptyList()
    }

}