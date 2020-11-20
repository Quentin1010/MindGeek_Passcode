package com.example.mindgeek_test.base

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.mindgeek_test.navigation.NavigationCommand
import javax.inject.Inject

abstract class BaseFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract val viewModel : BaseViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                viewModel.onBackPressed()
            }
        })

        viewModel.navigationCommands.observe(viewLifecycleOwner) { command ->
            if (command != null) {
                onNavigate(command)
            }
        }
    }

    open fun onNavigate(command: NavigationCommand) {}

    open fun onBackPressed() {}
}