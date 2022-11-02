package com.khvatid.ashuluk.domain.usecase

import com.khvatid.ashuluk.domain.service.AccountService

class SignOutUseCase(private val service: AccountService) {
    fun execute() {
        service.signOut()
    }
}