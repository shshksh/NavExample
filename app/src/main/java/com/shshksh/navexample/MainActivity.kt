package com.shshksh.navexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.shshksh.navexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val host = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.home_dest, R.id.noti_dest), binding.layoutDrawerMain)

        binding.toolbarTop.setupWithNavController(navController, appBarConfiguration)

        binding.navDrawer.setupWithNavController(navController)

        binding.navBottom.setupWithNavController(navController)
    }
}