package com.shshksh.navexample

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFirstFragment()
            1 -> HomeSecondFragment()
            2 -> HomeThirdFragment()
            else -> throw IllegalStateException()
        }
    }
}