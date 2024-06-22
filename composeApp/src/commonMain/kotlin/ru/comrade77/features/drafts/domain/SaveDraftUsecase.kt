package ru.comrade77.features.drafts.domain

import kotlinx.uuid.UUID
import ru.comrade77.core.database.AppDatabase
import ru.comrade77.core.di.InjectProvider
import ru.comrade77.features.drafts.data.DraftDao
import ru.comrade77.features.drafts.data.DraftEntity

class SaveDraftUsecase(
    private val draftDao: DraftDao
) {
    suspend fun execute(title: String, text: String) {
        DraftEntity(
            draftId = UUID().toString(false),
            title = title,
            text = text
        )
    }
}