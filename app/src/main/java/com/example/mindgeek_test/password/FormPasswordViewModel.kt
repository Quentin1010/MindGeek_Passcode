package com.example.mindgeek_test.password

import androidx.databinding.ObservableField
import com.example.mindgeek_test.base.BaseViewModel
import com.example.mindgeek_test.base.contract.ResourcesServiceInterface

abstract class FormPasswordViewModel(
    val resourcesService: ResourcesServiceInterface
) : BaseViewModel() {

    val screenTitle = ObservableField<String>()
    val errorMessage = ObservableField<String>()
    val digit1 = ObservableField<String>()
    val digit2 = ObservableField<String>()
    val digit3 = ObservableField<String>()
    val digit4 = ObservableField<String>()

    abstract fun onConfirmButton()

    protected fun isFormNotFilled(): Boolean {
        return digit1.get().isNullOrEmpty()
                || digit2.get().isNullOrEmpty()
                || digit3.get().isNullOrEmpty()
                || digit4.get().isNullOrEmpty()
    }

    protected fun getPasswordInTextFields(): String {
        return "${digit1.get()}${digit2.get()}${digit3.get()}${digit4.get()}"
    }

    protected fun clearTextFields() {
        digit1.set("")
        digit2.set("")
        digit3.set("")
        digit4.set("")
    }

}