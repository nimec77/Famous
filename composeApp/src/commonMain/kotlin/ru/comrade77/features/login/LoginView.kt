package ru.comrade77.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.features.login.models.LoginEvent
import ru.comrade77.features.login.models.LoginViewState

@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit,
) {
    Column {
        Text(viewState.emailValue)
        Text(viewState.passwordValue)
    }
}

@Composable
@Preview
internal fun LoginView_Preview() {
    LoginView(
        viewState = LoginViewState(
            emailValue = "nimec77@gmail.com",
            passwordValue = "12345"
        ),
        eventHandler = {}
    )
}