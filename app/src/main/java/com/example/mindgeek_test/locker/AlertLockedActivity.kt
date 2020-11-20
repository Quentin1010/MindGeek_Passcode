package com.example.mindgeek_test.locker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mindgeek_test.R
import kotlinx.android.synthetic.main.alert_locked_activity.*

class AlertLockedActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.alert_locked_activity)

        setFinishOnTouchOutside(false)

        button_ok.setOnClickListener {
            finish()
        }
    }
}