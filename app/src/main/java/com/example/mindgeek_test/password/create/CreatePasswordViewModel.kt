package com.example.mindgeek_test.password.create

import com.example.mindgeek_test.R
import com.example.mindgeek_test.base.contract.ResourcesServiceInterface
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.password.FormPasswordViewModel
import com.example.mindgeek_test.password.PasswordServiceInterface
import javax.inject.Inject

class CreatePasswordViewModel @Inject constructor(
    private val passwordService: PasswordServiceInterface,
    resourcesService: ResourcesServiceInterface
) : FormPasswordViewModel(resourcesService) {

    private var isConfirming = false
    private var passwordCached: String = ""

    init {
        setTitleCreateStep()
    }

    override fun onConfirmButton() {
        errorMessage.set(null)
        if (isFormNotFilled()) {
            errorMessage.set(resourcesService.getResources().getString(R.string.error_not_filled))
            return
        }

        if (isConfirming.not()) {
            passwordCached = getPasswordInTextFields()

            clearTextFields()
            setTitleConfirmStep()

            isConfirming = true
        } else {
            if (passwordCached == getPasswordInTextFields()) {
                passwordService.setPassword(passwordCached)
                navigate(Destination.NEXT)
            } else {
                errorMessage.set(resourcesService.getResources().getString(R.string.error_not_same))
            }
        }
    }

    private fun setTitleCreateStep() {
        screenTitle.set(resourcesService.getResources().getString(R.string.create_password))
    }

    private fun setTitleConfirmStep() {
        screenTitle.set(resourcesService.getResources().getString(R.string.confirm_password))
    }

    override fun onBackPressed() {
        if (isConfirming.not()) {
            navigateBack()
        } else {
            clearTextFields()
            setTitleCreateStep()
            errorMessage.set(null)
            isConfirming = false
        }
    }
}