package com.khvatid.ashuluk.ui.screens.settings

import androidx.lifecycle.ViewModel
import com.khvatid.ashuluk.domain.entities.LaunchEntity
import com.khvatid.ashuluk.domain.usecase.DeleteAccountUseCase
import com.khvatid.ashuluk.domain.usecase.SetLaunchEntityUseCase
import com.khvatid.ashuluk.domain.usecase.SignOutUseCase
import com.khvatid.ashuluk.domain.util.ParentDestination
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarManager
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarMessage.Companion.toSnackBarMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val setLaunchEntityUseCase: SetLaunchEntityUseCase,
    private val deleteAccountUseCase: DeleteAccountUseCase,
    private val signOutUseCase: SignOutUseCase
) : ViewModel() {

    fun deleteAccount(clearAndNavigate: (String) -> Unit) {
        deleteAccountUseCase.execute {
            if (it == null) {
                setLaunchEntityUseCase.execute(
                    launchEntity = LaunchEntity(
                        startDestination = ParentDestination.AUTH,
                        token = "empty"
                    )
                )
                clearAndNavigate(ParentDestination.AUTH)
            } else {
                SnackbarManager.showMessage(it.toSnackBarMessage())
            }
        }
    }

    fun signOut(clearAndNavigate: (String) -> Unit) {
        signOutUseCase.execute()
        setLaunchEntityUseCase.execute(
            launchEntity = LaunchEntity(
                startDestination = ParentDestination.AUTH,
                token = "empty"
            )
        )
        clearAndNavigate(ParentDestination.AUTH)
    }
}