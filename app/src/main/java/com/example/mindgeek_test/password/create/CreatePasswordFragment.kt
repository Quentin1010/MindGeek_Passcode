package com.example.mindgeek_test.password.create

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mindgeek_test.NavGraphDirections
import com.example.mindgeek_test.base.BaseApp
import com.example.mindgeek_test.base.BaseFragment
import com.example.mindgeek_test.databinding.FormPasswordFragmentBinding
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.navigation.NavigationCommand

class CreatePasswordFragment: BaseFragment() {

    override val viewModel by viewModels<CreatePasswordViewModel>{ viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FormPasswordFragmentBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onNavigate(command: NavigationCommand) {
        when(command.destination) {
            Destination.UP -> onBackPressed()
            Destination.NEXT -> findNavController().navigate(NavGraphDirections.popupToMain())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        findNavController().navigateUp()
    }
}