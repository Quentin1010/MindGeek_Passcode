package com.example.mindgeek_test.base

import android.app.Dialog
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.mindgeek_test.navigation.NavigationCommand
import javax.inject.Inject

abstract class BaseDialogFragment: DialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract val viewModel : BaseViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(requireContext(), theme) {
            override fun onBackPressed() {
                viewModel.onBackPressed()
            }
        }.apply {
            setCanceledOnTouchOutside(false)
        }
    }

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
}