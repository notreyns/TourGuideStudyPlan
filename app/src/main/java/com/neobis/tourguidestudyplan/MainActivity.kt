package com.neobis.tourguidestudyplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.neobis.tourguidestudyplan.adapters.MyPageAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager : ViewPager2
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)
        val viewPagerAdapter = MyPageAdapter(this)
        viewPager.adapter = viewPagerAdapter

        val newTiles = resources.getStringArray(R.array.titles)
        val titles = arrayListOf<String>("Рестораны", "Фитнес-центры", "Кинотеатры")
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = newTiles[position]
        }.attach()

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextAppearance(this, R.style.my_toolbar)
    }
}