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
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.weekfinal.h20185256.project_final.databinding.ActivityMainPager2Binding

class MainPagerActivity2 : AppCompatActivity() {
    //lateinit var toggle : ActionBarDrawerToggle
    lateinit var navigationView: NavigationView
    var now_fragment : String? = "Tab1"
    val binding : ActivityMainPager2Binding by lazy { ActivityMainPager2Binding.inflate(layoutInflater) }
    //var drawer_State = onDrawerClosed()

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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.person_30px)

        binding.navigationBtnContact.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                AlertDialog.Builder(this).run {
                    setTitle("Confirm")
                    setMessage("Do you wish to continue?")
                    setPositiveButton("SUBMIT", eventHandler)
                    setNegativeButton("CANCEL", null)
                    show()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        //inflater.inflate(R.menu.main_menu, menu)

        binding.toolbar.inflateMenu(R.menu.main_menu)

        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.menu_fold -> {
                    binding.drawer.openDrawer(GravityCompat.END)

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