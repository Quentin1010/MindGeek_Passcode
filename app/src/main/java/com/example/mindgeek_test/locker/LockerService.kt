package com.example.mindgeek_test.locker

import android.content.SharedPreferences
import javax.inject.Inject

class LockerService @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : LockerServiceInterface {

    override fun isLocked(): Boolean {
        val lockDate = sharedPreferences.getLong(LOCK_DATE_KEY, 0)
        return lockDate + LOCK_TIME_MILLI > System.currentTimeMillis()
    }

    override fun lock() {
        sharedPreferences.edit().putLong(LOCK_DATE_KEY, System.currentTimeMillis()).apply()
    }

    companion object {
        const val LOCK_DATE_KEY = "lockDateKey"
        const val LOCK_TIME_MILLI = 1 * 60 * 1000L
    }
}