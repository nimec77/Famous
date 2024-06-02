package ru.comrade77.features.profile.presentation.models

sealed class ProfileEvent {
    class TabSelected(val selectedIndex: Int) : ProfileEvent()
}