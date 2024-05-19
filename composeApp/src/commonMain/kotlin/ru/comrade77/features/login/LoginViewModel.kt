package ru.comrade77.features.login

import ru.comrade77.base.BaseViewModel
import ru.comrade77.features.login.models.LoginAction
import ru.comrade77.features.login.models.LoginEvent
import ru.comrade77.features.login.models.LoginViewState

class LoginViewModel: BaseViewModel<LoginViewState, LoginAction, LoginEvent>(initialState = LoginViewState()) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        TODO("Not yet implemented")
    }

}