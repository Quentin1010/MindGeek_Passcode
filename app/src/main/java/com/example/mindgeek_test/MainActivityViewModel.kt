package com.example.mindgeek_test

import com.example.mindgeek_test.base.BaseViewModel
import com.example.mindgeek_test.locker.LockerServiceInterface
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.password.PasswordServiceInterface
import com.example.mindgeek_test.password.SessionServiceInterface
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val sessionService: SessionServiceInterface,
    private val passwordService: PasswordServiceInterface,
    private val lockerService: LockerServiceInterface
): BaseViewModel() {

    fun onResumeActivity(currentDestination: Int?){
        if (lockerService.isLocked()){
            navigate(Destination.ALERT_LOCKED)
        } else if (sessionService.isSessionUnlocked().not()
            && currentDestination != R.id.DialogRequestPasswordFragment
            && passwordService.getPassword().isNullOrEmpty().not()
        ){
            navigate(Destination.REQUEST_PASSWORD)
        }
    }

    fun onStopActivity(){
        sessionService.setSessionUnlocked(false)
    }
}