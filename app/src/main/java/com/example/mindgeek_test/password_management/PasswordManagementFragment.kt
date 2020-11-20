package com.example.mindgeek_test.password_management

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mindgeek_test.base.BaseApp
import com.example.mindgeek_test.base.BaseFragment
import com.example.mindgeek_test.databinding.PasswordManagementFragmentBinding
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.navigation.NavigationCommand

class PasswordManagementFragment: BaseFragment() {

    override val viewModel by viewModels<PasswordManagementViewModel>{ viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = PasswordManagementFragmentBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onNavigate(command: NavigationCommand) {
        when(command.destination) {
            Destination.REQUEST_PASSWORD -> findNavController().navigate(PasswordManagementFragmentDirections.actionPasswordManagementFragmentToDialogRequestPasswordFragment(Destination.CREATE_PASSWORD))
            Destination.UP -> onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        findNavController().navigateUp()
    }
}