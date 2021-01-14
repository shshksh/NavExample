package com.shshksh.navexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shshksh.navexample.databinding.FragmentHomeBinding
import com.shshksh.navexample.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHome.setOnClickListener {
            Log.d(this@NotificationFragment::class.simpleName, "onViewCreated: click next action")
            val action = NotificationFragmentDirections.actionNotificationFragmentToNotificationNextFragment()
            findNavController().navigate(action)
        }
    }

}