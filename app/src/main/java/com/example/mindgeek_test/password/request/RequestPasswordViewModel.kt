package com.example.mindgeek_test.password.request

import com.example.mindgeek_test.R
import com.example.mindgeek_test.base.contract.ResourcesServiceInterface
import com.example.mindgeek_test.locker.LockerServiceInterface
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.password.FormPasswordViewModel
import com.example.mindgeek_test.password.PasswordServiceInterface
import com.example.mindgeek_test.password.SessionServiceInterface
import javax.inject.Inject

class RequestPasswordViewModel @Inject constructor(
    private val passwordService: PasswordServiceInterface,
    private val lockerService: LockerServiceInterface,
    private val sessionService: SessionServiceInterface,
    resourcesService: ResourcesServiceInterface
) : FormPasswordViewModel(resourcesService) {

    private var tryCount = 0
    var allowBack = true

    init {
        screenTitle.set(resourcesService.getResources().getString(R.string.enter_password))
    }

    override fun onConfirmButton() {
        errorMessage.set(null)
        if (isFormNotFilled()) {
            errorMessage.set(resourcesService.getResources().getString(R.string.error_not_filled))
            return
        }

        val password = getPasswordInTextFields()
        if (password == passwordService.getPassword()) {
            sessionService.setSessionUnlocked(true)
            navigate(Destination.NEXT)
        } else {
            tryCount++
            if (tryCount >= MAX_TRY){
                lockerService.lock()
                navigate(Destination.ALERT_LOCKED)
            }
            else {
                errorMessage.set(resourcesService.getResources().getString(R.string.error_incorrect_password))
            }
        }
    }

    override fun onBackPressed() {
        if(allowBack){
            navigate(Destination.UP)
        }
    }

    companion object {
        const val MAX_TRY = 3
    }
}