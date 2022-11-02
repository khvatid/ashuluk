package com.khvatid.ashuluk.domain.usecase

import com.khvatid.ashuluk.domain.service.AccountService

class AuthenticateToEmailAndPasswordUseCase(private val accountService: AccountService) {
    fun execute(email: String, password: String, onResult: (Throwable?) -> Unit) {
        accountService.authenticateToEmailAndPassword(email, password, onResult)
    }
}