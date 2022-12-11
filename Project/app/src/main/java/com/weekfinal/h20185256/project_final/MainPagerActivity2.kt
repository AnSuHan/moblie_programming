package com.weekfinal.h20185256.project_final

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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

        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.tabContent, MainPagerFragment()).commit()

        val tabLayout = binding.tabs

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text) {
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
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
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
        binding.mainDrawerView.findViewById<Button>(R.id.navigation_collapse).setOnClickListener {
            binding.drawer.closeDrawer(Gravity.RIGHT)
        }
        binding.mainDrawerView.findViewById<Button>(R.id.navigation_returnIntro).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
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

    //https://stackoverflow.com/questions/59516016/how-to-change-between-fragments-with-buttons-inside-the-fragments-in-kotlin
    fun changeFragment(str : String){
        lateinit var fragment : Fragment

        when(str) {
            "Tab1" -> fragment = MainPagerFragment()
            "Tab2" -> fragment = FirstPortfolio()
            "Tab3" -> fragment = SecondPortfolio()
            "Tab4" -> fragment = ThirdPortfolio()
            "Tab5" -> fragment = NthPortfolio()
        }


        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.tabContent, fragment)
            .commit()
    }


    //https://github.com/robolectric/robolectric/issues/3698
    //https://start1a.tistory.com/50
    public fun changeTab(str : String) {
        Log.d("kkang", "chageTab in MainPagerActivity2 : $str")

        val transaction = supportFragmentManager.beginTransaction()

        Log.d("kkang", "nowfragment : ${now_fragment}")         //Tab1

        if(now_fragment == str) {           //Tab1과 같이 String으로 사용 가능
            Log.d("kkang", "equal")
        } else {
            Log.d("kkang", "not equal")
        }


        when(str) {
            "Tab1" -> transaction.replace(R.id.tabContent, MainPagerFragment())
            "Tab2" -> transaction.replace(R.id.tabContent, FirstPortfolio())
            "Tab3" -> transaction.replace(R.id.tabContent, SecondPortfolio())
            "Tab4" -> transaction.replace(R.id.tabContent, ThirdPortfolio())
            "Tab5" -> transaction.replace(R.id.tabContent, NthPortfolio())
        }

        //https://proandroiddev.com/illegalstateexception-you-used-a-fragment-99816e7cf71b
        Log.d("kkang", "${supportFragmentManager.isStateSaved}")    //false

        //https://medium.com/hongbeomi-dev/%EB%B2%88%EC%97%AD-%EB%8B%A4%EC%96%91%ED%95%9C-%EC%A2%85%EB%A5%98%EC%9D%98-commit-8f646697559f
        transaction.commitNow()
        //transaction.commitAllowingStateLoss()
        //transaction.commitNowAllowingStateLoss()

        /*
        //java.lang.IllegalStateException: This transaction is already being added to the back stack
        transaction.addToBackStack(null)
        transaction.commitNowAllowingStateLoss()
         */
        //https://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
    }

    /*
    public fun changedFragmentStates(str : String) {
        clickChangeButton = true
        new_fragment = str
        onCreate(saved_Bundle)
    }
     */

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