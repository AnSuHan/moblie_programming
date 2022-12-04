package com.weekfinal.h20185256.project_final

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.tabs.TabLayout
import com.weekfinal.h20185256.project_final.databinding.ActivityContactLayoutBinding
import com.weekfinal.h20185256.project_final.databinding.ActivityMainPager2Binding

class MainPagerActivity2 : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    var now_fragment : String? = "Tab1"
    val binding : ActivityMainPager2Binding by lazy { ActivityMainPager2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val binding = ActivityMainPager2Binding.inflate(layoutInflater)
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
                    "Tab4" -> transaction.replace(R.id.tabContent, ThirdPortfolio())
                    "Tab5" -> transaction.replace(R.id.tabContent, NthPortfolio())
                }
                now_fragment = tab?.text.toString()

                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //Log.d("kkang", "onTabUnselected..")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //Log.d("kkang", "onTabReselected..")
            }

        })

        //toolbar
        setSupportActionBar(binding.toolbar)
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)  // 왼쪽 버튼 사용 여부 true


        //toggle 버튼 적용
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        toggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        //inflater.inflate(R.menu.main_menu, menu)

        binding.toolbar.inflateMenu(R.menu.main_menu)

        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.menu_person -> {
                    AlertDialog.Builder(this).run {
                        setTitle("Confirm")
                        setMessage("Do you wish to continue?")
                        setPositiveButton("SUBMIT", eventHandler)
                        setNegativeButton("CANCEL", null)
                        show()
                    }

                    true
                }
                R.id.menu_fold -> {
                    //drawer

                    true
                }
                else -> {
                    false
                }
            }
        }

        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nowFragment", now_fragment)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {   //not working
        super.onRestoreInstanceState(savedInstanceState)
        now_fragment = savedInstanceState.getString("nowfragment")

        val transaction = supportFragmentManager.beginTransaction()
        when(now_fragment) {
            "Tab1" -> transaction.replace(R.id.tabContent, MainPagerFragment())
            "Tab2" -> transaction.replace(R.id.tabContent, FirstPortfolio())
            "Tab3" -> transaction.replace(R.id.tabContent, SecondPortfolio())
            "Tab4" -> transaction.replace(R.id.tabContent, ThirdPortfolio())
            "Tab5" -> transaction.replace(R.id.tabContent, NthPortfolio())
        }

        transaction.commit()
    }

    val eventHandler = object : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            if(p1 == DialogInterface.BUTTON_POSITIVE) {
                val context = applicationContext //requireContext()

                val intent = Intent(context, EditProfileImageActivity::class.java)
                startActivity(intent)
            }
        }
    }
}