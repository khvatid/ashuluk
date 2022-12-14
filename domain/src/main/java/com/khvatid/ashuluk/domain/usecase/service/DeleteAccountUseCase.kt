package com.khvatid.ashuluk.domain.usecase.service

import com.khvatid.ashuluk.domain.service.AccountService

class DeleteAccountUseCase(private val service: AccountService) {
    fun execute(onResult: (Throwable?) -> Unit) {
        service.deleteAccount(onResult = onResult)
    }
}