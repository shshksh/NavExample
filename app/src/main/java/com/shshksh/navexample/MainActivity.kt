package com.shshksh.navexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.navigation.fragment.NavHostFragment
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
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.home_dest, R.id.noti_dest), binding.layoutDrawerMain)
//
//        binding.toolbarTop.setupWithNavController(navController, appBarConfiguration)

        binding.navDrawer.setupWithNavController(navController)

        val homeStartDestination = NavHostFragment.create(R.navigation.nav_home)
        val notificationStartDestination = NavHostFragment.create(R.navigation.nav_noti)

//        binding.navBottom.setupWithNavController(navController)
        binding.navBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, homeStartDestination)
                        .setPrimaryNavigationFragment(homeStartDestination)
                        .commit()
                    true
                }
                R.id.nav_noti -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, notificationStartDestination)
                        .setPrimaryNavigationFragment(notificationStartDestination)
                        .commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
        binding.navBottom.menu[1].isEnabled = false
    }
}