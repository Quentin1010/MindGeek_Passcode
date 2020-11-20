package com.example.mindgeek_test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mindgeek_test.base.BaseApp
import com.example.mindgeek_test.base.BaseFragment
import com.example.mindgeek_test.databinding.MainFragmentBinding
import com.example.mindgeek_test.locker.AlertLockedActivity
import com.example.mindgeek_test.navigation.Destination.*
import com.example.mindgeek_test.navigation.NavigationCommand

class MainFragment: BaseFragment() {

    override val viewModel by viewModels<MainViewModel>{ viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MainFragmentBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onNavigate(command: NavigationCommand) {

        when(command.destination) {
            CREATE_PASSWORD -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToCreatePasswordFragment())
            REQUEST_PASSWORD -> findNavController().navigate(NavGraphDirections.openRequestPassword())
            PASSWORD_MANAGEMENT -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToPasswordManagementFragment())
            ALERT_LOCKED -> {
                startActivity(Intent(requireActivity(), AlertLockedActivity::class.java))
            }
            UP -> onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        requireActivity().finish()
    }
}