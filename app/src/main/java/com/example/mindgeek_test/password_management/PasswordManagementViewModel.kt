package com.example.mindgeek_test.password_management

import com.example.mindgeek_test.base.BaseViewModel
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.password.PasswordServiceInterface
import javax.inject.Inject

class PasswordManagementViewModel @Inject constructor (
    private val passwordService: PasswordServiceInterface
): BaseViewModel() {

    fun onBackClicked() {
        navigateBack()
    }

    fun onTurnOffPasswordClick() {
        passwordService.clearPassword()
        navigateBack()
    }

    fun onEditPasswordClick(){
        navigate(Destination.REQUEST_PASSWORD)
    }

}
