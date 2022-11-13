package com.weekfinal.h20185256.project_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import com.weekfinal.h20185256.project_final.databinding.ActivityMainPager2Binding

class MainPagerActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main3)

        val binding = ActivityMainPager2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.tabContent, MainPagerFragment()).commit()

        val tabLayout = binding.tabs


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.text) {
                    "Tab1" -> transaction.replace(R.id.tabContent, MainPagerFragment())
                    "Tab2" -> transaction.replace(R.id.tabContent, FirstPortfolio())
                    "Tab3" -> transaction.replace(R.id.tabContent, SecondPortfolio())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("kkang", "onTabUnselected..")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("kkang", "onTabReselected..")
            }

        })
    }
}