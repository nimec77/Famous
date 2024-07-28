package ru.comrade77.features.create

import ru.comrade77.base.BaseViewModel
import ru.comrade77.features.create.models.CreatePostAction
import ru.comrade77.features.create.models.CreatePostEvent
import ru.comrade77.features.create.models.CreatePostViewState

class CreatePostViewModel : BaseViewModel<CreatePostViewState, CreatePostAction, CreatePostEvent>(initialState = CreatePostViewState()) {
    override fun obtainEvent(viewEvent: CreatePostEvent) {
    }

}