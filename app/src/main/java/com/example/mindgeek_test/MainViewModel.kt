package com.example.mindgeek_test

import com.example.mindgeek_test.base.BaseViewModel
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.password.PasswordServiceInterface
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val passwordService: PasswordServiceInterface
): BaseViewModel() {

    fun onLockClick() {
        if (passwordService.getPassword().isNullOrEmpty()) {
            navigate(Destination.CREATE_PASSWORD)
        }
        else {
            navigate(Destination.PASSWORD_MANAGEMENT)
        }
    }

    fun onTestClick() {
        navigate(Destination.ALERT_LOCKED)
    }
}