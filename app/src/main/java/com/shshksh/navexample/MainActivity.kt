package com.shshksh.navexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
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

        binding.navBottom.menu[1].isEnabled = false

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.notificationFragment), binding.layoutDrawerMain)
        val navGraphIds = listOf(R.navigation.nav_home, R.navigation.nav_noti)
        val controller = binding.navBottom.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.nav_host_fragment,
                intent = intent
        )

        controller.observe(this, { navController ->
            setSupportActionBar(binding.toolbarTop)
            binding.toolbarTop.setupWithNavController(navController, appBarConfiguration)
            binding.navDrawer.setupWithNavController(navController)
        })
    }
}