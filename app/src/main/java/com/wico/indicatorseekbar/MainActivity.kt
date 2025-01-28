package com.wico.indicatorseekbar

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.wico.fragment.ContinuousFragment
import com.wico.fragment.DiscreteFragment

class MainActivity : BaseActivity() {

    private val tabTypes = listOf("continuous", "discrete", "custom", "java", "indicator", "donation")
    private val fragments = mutableListOf<Fragment>()

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun initCreate() {
        super.initCreate()
        setupFragments()
        initializeViews()
        demonstrateStringUtils()
    }

    private fun setupFragments() {
        fragments.apply {
            add(ContinuousFragment())
            add(DiscreteFragment())
            add(ContinuousFragment())
            add(DiscreteFragment())
            add(ContinuousFragment())
            add(DiscreteFragment())
        }
    }

    private fun initializeViews() {
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(
            findViewById(R.id.tabLayout),
            viewPager
        ) { tab, position ->
            tab.text = tabTypes[position]
        }.attach()
    }

    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = tabTypes.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }
    
    private fun demonstrateStringUtils() {
        // Generate sample password with mixed requirements
        val password = generatePassword(
            length = 14,
            hasUppercase = false,
            hasLowercase = false

        )
        
        Log.d("PasswordDemo", "Generated password: $password")
        Log.d("PasswordDemo", "Meets complexity: ${
            password.hasUppercase() 
        }")
    }
}