package com.neobis.tourguidestudyplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager : ViewPager2
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)
        val viewPagerAdapter = MyPageAdapter(this)
        viewPager.adapter = viewPagerAdapter


        val titles = arrayListOf<String>("Рестораны", "Фитнес-центры", "Кинотеатры")
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = titles[position]
        }.attach()

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextAppearance(this, R.style.my_toolbar)
    }
}