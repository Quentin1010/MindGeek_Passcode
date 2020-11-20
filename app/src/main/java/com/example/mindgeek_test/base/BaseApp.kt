package com.example.mindgeek_test.base

import android.app.Application
import com.example.mindgeek_test.di.AppModule
import com.example.mindgeek_test.di.ApplicationComponent
import com.example.mindgeek_test.di.DaggerApplicationComponent

class BaseApp: Application() {
    companion object {
        lateinit var instance: BaseApp
        lateinit var appComponent: ApplicationComponent
    }

    private fun initializeDagger() {
        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        instance = this
    }
}