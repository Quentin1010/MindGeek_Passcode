package com.example.mindgeek_test.di

import androidx.lifecycle.ViewModel
import com.example.mindgeek_test.MainActivityViewModel
import com.example.mindgeek_test.MainViewModel
import com.example.mindgeek_test.base.ResourcesService
import com.example.mindgeek_test.base.contract.ResourcesServiceInterface
import com.example.mindgeek_test.locker.LockerService
import com.example.mindgeek_test.locker.LockerServiceInterface
import com.example.mindgeek_test.password.PasswordService
import com.example.mindgeek_test.password.PasswordServiceInterface
import com.example.mindgeek_test.password.SessionService
import com.example.mindgeek_test.password.SessionServiceInterface
import com.example.mindgeek_test.password.create.CreatePasswordViewModel
import com.example.mindgeek_test.password.request.RequestPasswordViewModel
import com.example.mindgeek_test.password_management.PasswordManagementViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppModuleBinds {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewmodel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewmodel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PasswordManagementViewModel::class)
    abstract fun bindPasswordManagementViewModel(viewmodel: PasswordManagementViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreatePasswordViewModel::class)
    abstract fun bindCreatePasswordViewModel(viewmodel: CreatePasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestPasswordViewModel::class)
    abstract fun bindRequestPasswordViewModel(viewmodel: RequestPasswordViewModel): ViewModel

    @Binds
    abstract fun providesPasswordService(passwordService: PasswordService): PasswordServiceInterface

    @Binds
    abstract fun providesResourcesService(resourcesService: ResourcesService): ResourcesServiceInterface

    @Binds
    abstract fun providesLockerService(lockerService: LockerService): LockerServiceInterface

    @Binds
    abstract fun providesSessionService(lockerService: SessionService): SessionServiceInterface
}