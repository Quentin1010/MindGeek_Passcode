package com.example.mindgeek_test.password

interface PasswordServiceInterface {

    fun getPassword(): String?
    fun setPassword(password: String)
    fun clearPassword()

}