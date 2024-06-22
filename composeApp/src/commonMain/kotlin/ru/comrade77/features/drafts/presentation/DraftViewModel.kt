package ru.comrade77.features.drafts.presentation

import ru.comrade77.core.di.InjectProvider
import ru.comrade77.features.drafts.domain.SaveDraftUsecase

class DraftViewModel() {
    private val saveDraftUsecase = SaveDraftUsecase(draftDao = InjectProvider.getDatabase().getDraftDao())
}