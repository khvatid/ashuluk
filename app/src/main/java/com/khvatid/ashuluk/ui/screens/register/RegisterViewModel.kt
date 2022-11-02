package com.khvatid.ashuluk.ui.screens.register

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.khvatid.ashuluk.domain.entities.LaunchEntity
import com.khvatid.ashuluk.domain.usecase.CreateAccountToEmailAndPasswordUseCase
import com.khvatid.ashuluk.domain.usecase.SetLaunchEntityUseCase
import com.khvatid.ashuluk.domain.util.ParentDestination
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarManager
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarMessage.Companion.toSnackBarMessage
import com.khvatid.ashuluk.ui.navigation.UiRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel
@Inject constructor(
    private val createAccountToEmailAndPasswordUseCase: CreateAccountToEmailAndPasswordUseCase,
    private val setLaunchEntityUseCase: SetLaunchEntityUseCase
) :
    ViewModel() {

    var uiState: MutableState<RegisterUiState> = mutableStateOf(RegisterUiState())
        private set

    fun onEmailChange(value: String) {
        uiState.value = uiState.value.copy(mail = value).update()
    }

    fun onPasswordChange(value: String) {
        uiState.value = uiState.value.copy(password = value).update()
    }

    fun onPasswordReplyChanged(value: String) {
        uiState.value = uiState.value.copy(passwordReply = value).update()
    }

    fun createAccount(openSingleTop: (String) -> Unit) {
        createAccountToEmailAndPasswordUseCase.execute(
            uiState.value.mail,
            uiState.value.password
        ) { error ->
            if (error == null) {
                setLaunchEntityUseCase.execute(
                    LaunchEntity(
                        startDestination = ParentDestination.MAIN,
                        token = uiState.value.mail
                    )
                )
                openSingleTop(UiRoutes.MAIN)
            } else {
                SnackbarManager.showMessage(error.toSnackBarMessage())
            }
        }
    }

}