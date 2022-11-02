package com.khvatid.ashuluk.ui.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.khvatid.ashuluk.domain.entities.LaunchEntity
import com.khvatid.ashuluk.domain.usecase.AuthenticateToEmailAndPasswordUseCase
import com.khvatid.ashuluk.domain.usecase.SetLaunchEntityUseCase
import com.khvatid.ashuluk.domain.util.ParentDestination
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarManager
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarMessage.Companion.toSnackBarMessage
import com.khvatid.ashuluk.ui.navigation.UiRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticateToEmailAndPasswordUseCase: AuthenticateToEmailAndPasswordUseCase,
    private val setLaunchEntityUseCase: SetLaunchEntityUseCase
) :
    ViewModel() {

    var uiState: MutableState<LoginUiState> = mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(value: String) {
        uiState.value = uiState.value.copy(mail = value)
    }

    fun onPasswordChange(value: String) {
        uiState.value = uiState.value.copy(password = value)
    }

    fun signInToEmailAndPassword(onResult: (String) -> Unit) {
        authenticateToEmailAndPasswordUseCase.execute(uiState.value.mail, uiState.value.password) {
            if (it == null) {
                setLaunchEntityUseCase.execute(
                    LaunchEntity(
                        startDestination = ParentDestination.MAIN,
                        token = uiState.value.mail
                    )
                )
                onResult(UiRoutes.MAIN)
            } else {
                SnackbarManager.showMessage(it.toSnackBarMessage())
            }
        }
    }
}