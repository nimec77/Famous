package ru.comrade77.features.login.models

sealed class LoginAction {
    data object OpenMainScreen: LoginAction()
}

