package com.splanes.apps.dutyfruty.ui.features.authentication

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.splanes.apps.dutyfruty.ui.features.authentication.components.form.SignUpFormData

@Composable
fun AuthRoute(
    viewModel: AuthViewModel,
    navToDashboard: () -> Unit,
) {
    val authState by viewModel.uiState.collectAsStateWithLifecycle()

    AuthRoute(
        state = authState,
        onSignUp = viewModel::onSignUp,
    )
}

@Composable
fun AuthRoute(
    state: AuthState,
    onSignUp: (SignUpFormData) -> Unit,
) {
    Crossfade(
        targetState = state,
        label = "AuthRoute Anim",
    ) { authState ->
        when (authState) {
            is AuthState.AutoSignIn -> AuthLoadingScreen()
            is AuthState.SignUp -> AuthSignUpScreen(onSignUp = onSignUp)
        }
    }
}
