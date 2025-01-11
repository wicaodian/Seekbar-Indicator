package com.wico.indicatorseekbar

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.wico.fragment.ContinuousFragment
import com.wico.fragment.DiscreteFragment

class MainActivity : BaseActivity() {

    private val sType = arrayOf("continuous", "discrete", "custom", "java", "indicator", "donation")
    private val mFragmentList = mutableListOf<Fragment>()

    override fun initCreate() {
        super.initCreate()
        initFragment()
        initViews()
    }

    override val layoutResId: Int
        get() = R.layout.activity_main

    private fun initFragment() {
        mFragmentList.apply {
            add(ContinuousFragment())
            add(DiscreteFragment())
            add(ContinuousFragment())
            add(DiscreteFragment())
            add(ContinuousFragment())
        }
    }

    private fun initViews() {
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        sType.forEach { s ->
            val textView = TextView(this).apply {
                text = s
            }
            tabLayout.newTab().customView = textView
        }
    }

    private inner class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return sType.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return sType[position]
        }
    }
}