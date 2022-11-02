package com.khvatid.ashuluk.domain.service

interface AccountService {
    fun hasUser(): Boolean
    fun getUserId(): String
    fun createAccountToEmailAndPassword(
        email: String,
        password: String,
        onResult: (Throwable?) -> Unit
    )
    fun authenticateToEmailAndPassword(
        email: String,
        password: String,
        onResult: (Throwable?) -> Unit
    )
    fun sendRecoveryEmail(email: String, onResult: (Throwable?) -> Unit)
    fun linkAccount(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun deleteAccount(onResult: (Throwable?) -> Unit)
    fun signOut()
}