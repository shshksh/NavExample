package com.shshksh.navexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shshksh.navexample.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if (binding.editId.text.toString() == "admin") {
                val action = LoginFragmentDirections.actionLoginDestToHomeDest()
                findNavController().navigate(action)
                activity?.findViewById<MaterialToolbar>(R.id.toolbar_top)?.visibility = View.VISIBLE
                activity?.findViewById<BottomNavigationView>(R.id.nav_bottom)?.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "Wrong ID", Toast.LENGTH_SHORT).show()
            }
        }
    }
}