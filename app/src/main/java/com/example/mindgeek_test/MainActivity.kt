package com.example.mindgeek_test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mindgeek_test.base.BaseApp
import com.example.mindgeek_test.locker.AlertLockedActivity
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.navigation.NavigationCommand
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        BaseApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        viewModel.navigationCommands.observe(this) { command ->
            if (command != null) {
                onNavigate(command)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResumeActivity(navController.currentDestination?.id)
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStopActivity()
    }

    private fun onNavigate(command: NavigationCommand){
        when(command.destination){
            Destination.ALERT_LOCKED -> startActivity(Intent(this, AlertLockedActivity::class.java))
            Destination.REQUEST_PASSWORD -> navController.navigate(NavGraphDirections.openRequestPassword(allowBack = false))
        }
    }
}