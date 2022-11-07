package com.khvatid.ashuluk.data.service

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.khvatid.ashuluk.domain.service.AccountService

class AccountServiceImp : AccountService {

    private val auth = Firebase.auth

    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override fun getUserId(): String {
        return auth.currentUser!!.uid
    }

    override fun createAccountToEmailAndPassword(
        email: String,
        password: String,
        onResult: (Throwable?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { onResult(it.exception) }
    }

    override fun authenticateToEmailAndPassword(
        email: String,
        password: String,
        onResult: (Throwable?) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { onResult(it.exception) }
    }

    override fun sendRecoveryEmail(email: String, onResult: (Throwable?) -> Unit) {
        TODO("SendRecoveryEmail need imp")
    }

    override fun linkAccount(email: String, password: String, onResult: (Throwable?) -> Unit) {
        TODO("linkAccount need imp")
    }

    override fun deleteAccount(onResult: (Throwable?) -> Unit) {
        auth.currentUser!!.delete().addOnCompleteListener { onResult(it.exception) }
    }

    override fun signOut() {
        auth.signOut()
    }
}