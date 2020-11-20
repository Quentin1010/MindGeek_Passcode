package com.example.mindgeek_test.password

import android.content.SharedPreferences
import javax.inject.Inject

class PasswordService @Inject constructor(
    private val sharedPreferences: SharedPreferences
): PasswordServiceInterface {

    override fun getPassword(): String? {
        return sharedPreferences.getString(PASSWORD_PREFERENCE_KEY, null)
    }

    override fun setPassword(password: String) {
        sharedPreferences.edit().putString(PASSWORD_PREFERENCE_KEY, password).apply()
    }

    override fun clearPassword() {
        sharedPreferences.edit().putString(PASSWORD_PREFERENCE_KEY, null).apply()
    }

    companion object {
        const val PASSWORD_PREFERENCE_KEY="password_key"
    }
}