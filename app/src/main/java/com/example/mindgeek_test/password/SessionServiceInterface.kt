package com.example.mindgeek_test.password

interface SessionServiceInterface {

    fun isSessionUnlocked(): Boolean
    fun setSessionUnlocked(unlocked: Boolean)
}