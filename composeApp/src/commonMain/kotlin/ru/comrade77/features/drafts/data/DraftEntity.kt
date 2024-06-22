package ru.comrade77.features.drafts.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DraftEntity (
    @PrimaryKey val draftId: String,
    val title: String,
    val text: String
)


