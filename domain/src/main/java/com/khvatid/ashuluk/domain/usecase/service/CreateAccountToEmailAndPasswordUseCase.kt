package com.khvatid.ashuluk.domain.usecase.service

import com.khvatid.ashuluk.domain.service.AccountService

class CreateAccountToEmailAndPasswordUseCase(private val accountService: AccountService) {
    fun execute(email: String, password: String, onResult: (Throwable?) -> Unit) {
        accountService.createAccountToEmailAndPassword(email, password, onResult)
    }
}