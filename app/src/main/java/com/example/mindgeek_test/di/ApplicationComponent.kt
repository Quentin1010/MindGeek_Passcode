package com.example.mindgeek_test.di

import com.example.mindgeek_test.MainActivity
import com.example.mindgeek_test.MainFragment
import com.example.mindgeek_test.locker.AlertLockedActivity
import com.example.mindgeek_test.password.create.CreatePasswordFragment
import com.example.mindgeek_test.password.request.RequestPasswordFragment
import com.example.mindgeek_test.password_management.PasswordManagementFragment
import com.example.mindgeek_test.splashscreen.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (
    modules = [
        AppModule::class,
        AppModuleBinds::class,
        ViewModelBuilderModule::class
])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)
    fun inject(activity: AlertLockedActivity)

    fun inject(fragment: MainFragment)
    fun inject(fragment: PasswordManagementFragment)
    fun inject(fragment: CreatePasswordFragment)
    fun inject(fragment: RequestPasswordFragment)
}
