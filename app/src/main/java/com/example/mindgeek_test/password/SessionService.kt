package com.example.mindgeek_test.password

import javax.inject.Inject

class SessionService @Inject constructor(): SessionServiceInterface {

    private var sessionUnlocked: Boolean = false

    override fun isSessionUnlocked(): Boolean {
        return sessionUnlocked
    }

    override fun setSessionUnlocked(unlocked: Boolean) {
        sessionUnlocked = unlocked
    }
}