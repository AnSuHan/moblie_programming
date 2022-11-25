package com.weekfinal.h20185256.project_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import com.google.android.material.tabs.TabLayout
import com.weekfinal.h20185256.project_final.databinding.ActivityMainPager2Binding

class MainPagerActivity2 : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    var isTab5Clicked = false

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
                    "Tab4" -> transaction.replace(R.id.tabContent, ThirdPortfolio())
                    "Tab5" -> isTab5Clicked = true
                }
                if(isTab5Clicked) {
                    isTab5Clicked = false

                    val intent = Intent(this, NthPortfolioActivity::class.java)
                    startActivity(intent)
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

        //toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)  // 왼쪽 버튼 사용 여부 true


        //toggle 버튼 적용
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        //MenuItem 객체를 얻고 그 안에 포함된 ActionView 객체 획득
        val menuItem = menu?.findItem(R.id.menu_person)
        //menu.add()
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                //검색어 변경
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                //검색 버튼 클릭한 순간
                Log.d("kkang", "search text : $query")
                return true
            }
        })

        return true
    }


}