package com.neobis.tourguidestudyplan.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.neobis.tourguidestudyplan.fragments.CinemaFragment
import com.neobis.tourguidestudyplan.fragments.FitnessFragment
import com.neobis.tourguidestudyplan.fragments.RestaurantFragment

class MyPageAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return RestaurantFragment()
            1 -> return FitnessFragment()
            else -> return CinemaFragment()
        }
    }
}