package com.example.mindgeek_test.base

import androidx.lifecycle.ViewModel
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.navigation.NavigationCommand

open class BaseViewModel: ViewModel() {

    val navigationCommands: SingleLiveEvent<NavigationCommand> =
        SingleLiveEvent()

    fun navigate(destination: Destination) {
        navigationCommands.postValue(NavigationCommand(destination))
    }

    fun navigateBack() {
        navigationCommands.postValue(NavigationCommand(Destination.UP))
    }

    open fun onBackPressed() {
        navigateBack()
    }
}