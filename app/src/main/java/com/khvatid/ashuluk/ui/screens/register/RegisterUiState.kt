package com.khvatid.ashuluk.ui.screens.register

data class RegisterUiState(
    val mail: String = "",
    val password: String = "",
    val passwordReply: String = "",
) {
    var isEnable: Boolean = false
        private set
    var isErrorPassword: Boolean = false
        private set
    var isErrorPasswordReply: Boolean = false
        private set

    fun update(): RegisterUiState {
        if (password != "") isErrorPassword = password.length < 6
        if (passwordReply != "") isErrorPasswordReply = password != passwordReply
        isEnable = if (mail == "" || password == "" || passwordReply == "") {
            false
        } else {
            !isErrorPassword && !isErrorPasswordReply
        }
        return this
    }
}