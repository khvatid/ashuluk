package com.khvatid.ashuluk.domain.usecase.service

import com.khvatid.ashuluk.domain.service.AccountService

class GetUserIdUseCase(private val service: AccountService) {
    fun execute(): String{
        return service.getUserId()
    }
}