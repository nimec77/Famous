package ru.comrade77.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.comrade77.features.drafts.data.DraftDao
import ru.comrade77.features.drafts.data.DraftEntity

@Database(entities = [DraftEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDraftDao(): DraftDao
}

internal const val dbFileName = "appfamous.db"

