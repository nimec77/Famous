package ru.comrade77.features.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import famous.composeapp.generated.resources.Res
import famous.composeapp.generated.resources.login_intro
import famous.composeapp.generated.resources.login_titile
import famous.composeapp.generated.resources.login_wellcome_back
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.comrade77.common.textfield.FTextField
import ru.comrade77.features.login.models.LoginEvent
import ru.comrade77.features.login.models.LoginViewState
import ru.comrade77.theme.AppTheme
import ru.comrade77.theme.FamousTheme

@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit,
) {
    Column {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = stringResource(Res.string.login_titile),
                modifier = Modifier.align(Alignment.Center),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
        }

        Box(
            modifier = Modifier.padding(top = 28.dp, bottom = 12.dp)
                .fillMaxWidth()
                .height(28.dp)
        ) {
            Text(
                text = stringResource(Res.string.login_wellcome_back),
                modifier = Modifier.align(Alignment.Center),
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            )
        }

        Box(
            modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(Res.string.login_intro),
                modifier = Modifier.align(Alignment.Center),
                color = FamousTheme.colors.primaryText,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            )
        }

        FTextField(text = viewState.emailValue) {
            eventHandler.invoke(LoginEvent.EmailChanged(it))
        }
        FTextField(text = viewState.passwordValue) {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }
    }
}

@Composable
@Preview
internal fun LoginView_Preview() {
    AppTheme {
        LoginView(
            viewState = LoginViewState(
                emailValue = "nimec77@gmail.com",
                passwordValue = "12345"
            ),
            eventHandler = {}
        )
    }
}