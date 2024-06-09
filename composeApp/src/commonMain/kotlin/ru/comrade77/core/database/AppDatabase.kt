package ru.comrade77.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class AppDatabase: RoomDatabase() {
    
}

internal const val dbFileName = "appfamous.db"

