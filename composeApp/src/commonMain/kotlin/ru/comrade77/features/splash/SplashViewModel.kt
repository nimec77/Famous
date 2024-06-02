package ru.comrade77.features.splash

import ru.comrade77.base.BaseViewModel
import ru.comrade77.features.login.domain.IsUserAuthorizedUseCase
import ru.comrade77.features.splash.models.SplashAction

class SplashViewModel(
    private val isUserAuthorizedUseCase: IsUserAuthorizedUseCase = IsUserAuthorizedUseCase()
) : BaseViewModel<Unit, SplashAction, Unit>(initialState = Unit) {

    init {
        checkUserAuthorized()
    }

    override fun obtainEvent(viewEvent: Unit) {

    }

    private fun checkUserAuthorized() {
        viewAction = if (isUserAuthorizedUseCase.execute()) {
            SplashAction.ShowMainScreen
        } else {
            SplashAction.ShowLoginScreen
        }
    }
}