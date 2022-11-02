package com.khvatid.ashuluk.ui.common.snackbar

import androidx.annotation.StringRes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object SnackbarManager {

    private val messages_: MutableStateFlow<SnackbarMessage?> = MutableStateFlow(null)
    val messages: StateFlow<SnackbarMessage?> get() = messages_.asStateFlow()

    fun showMessage(@StringRes message: Int) {
        messages_.value = SnackbarMessage.ResourceSnackbar(message)
    }

    fun showMessage(message: SnackbarMessage) {
        messages_.value = message
    }
}