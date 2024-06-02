package ru.comrade77.features.profile.presentation.models

import ru.comrade77.base.BaseViewModel

class ProfileViewModel() :
    BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent>(initialState = ProfileViewState(
        name = "Natalie",
        subscribers = "5.3m subscribers",
        joinedIn = "Joined in 2017"
    )) {
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when(viewEvent) {
            is ProfileEvent.TabSelected -> viewState = viewState.copy(selectedTabIndex = viewEvent.selectedIndex)
        }
    }

}