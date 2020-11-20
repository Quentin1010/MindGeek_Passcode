package com.example.mindgeek_test.password.request

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mindgeek_test.NavGraphDirections
import com.example.mindgeek_test.base.BaseApp
import com.example.mindgeek_test.base.BaseDialogFragment
import com.example.mindgeek_test.databinding.FormPasswordFragmentBinding
import com.example.mindgeek_test.locker.AlertLockedActivity
import com.example.mindgeek_test.navigation.Destination
import com.example.mindgeek_test.navigation.NavigationCommand


class RequestPasswordFragment : BaseDialogFragment() {

    override val viewModel by viewModels<RequestPasswordViewModel> { viewModelFactory }

    val args: RequestPasswordFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        BaseApp.appComponent.inject(this)
        viewModel.allowBack = args.allowBack
    }

    override fun onResume() {
        super.onResume()
        val display: Display = requireActivity().windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width: Int = size.x
        val height: Int = size.y
        dialog?.window?.setLayout((width * 0.90).toInt(), (height * 0.80).toInt())
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
        when (command.destination) {
            Destination.NEXT -> {
                onNavigate(NavigationCommand(args.destination ?: Destination.UP))
            }
            Destination.ALERT_LOCKED -> {
                findNavController().navigate(NavGraphDirections.popupToMain())
                startActivity(Intent(requireActivity(), AlertLockedActivity::class.java))
            }
            Destination.CREATE_PASSWORD -> findNavController().navigate(RequestPasswordFragmentDirections.actionDialogRequestPasswordFragmentToCreatePasswordFragment())
            Destination.UP -> findNavController().navigateUp()
        }
    }
}