package com.weekfinal.h20185256.project_final

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SettingsSlicesContract
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weekfinal.h20185256.project_final.databinding.ActivityNthPortfolioBinding

class NthPortfolioActivity : AppCompatActivity() {
    lateinit var binding : ActivityNthPortfolioBinding
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_nth_portfolio)

        binding = ActivityNthPortfolioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toolbar
        setSupportActionBar(binding.toolbar)

        //toggle 버튼 적용
        toggle = ActionBarDrawerToggle(this, binding.drawer2, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)   // 왼쪽 버튼 사용 여부 true
        toggle.syncState()

        //binding.drawer2.addDrawerListener(toggle)

        var drawerLayout = findViewById<DrawerLayout>(R.id.drawer2)



        val tmpTitle = mutableListOf<String>()

        binding.nthBtnAdd.setOnClickListener {
            //Log.d("kkang", "${binding.nthEditText.text}")

            if(binding.nthEditText.text != null) {
                Log.d("kkang", "${binding.nthEditText.text}")
                tmpTitle.add(binding.nthEditText.text.toString())


                val layoutManager = LinearLayoutManager(this as Context) //부모의 context 찾기
                binding.nthPortfolioActivityRecyclerView.layoutManager = layoutManager
                //val adapter = MyAdapter(tmpTitle)
                binding.nthPortfolioActivityRecyclerView.adapter = MyAdapter(tmpTitle)
                binding.nthPortfolioActivityRecyclerView.addItemDecoration(
                    DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
                )

                binding.nthEditText.text = null
            } else {
                Log.d("kkang", "text is null")
            }
        }

        binding.navigationBtnContact.setOnClickListener {
            //Log.d("kkang", "contact clicked")

            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        /*
        binding.mainDrawerView?.findViewById<Button>(R.id.navigation_returnIntro)?.setOnClickListener {
            Toast.makeText(this, "click btn_returnIntro", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.mainDrawerView?.findViewById<Button>(R.id.navigation_collapse)?.setOnClickListener {
            Toast.makeText(this, "click btn_collapse", Toast.LENGTH_SHORT).show()
        }
         */

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.title){
        "person" -> {
            //Log.d("kkang", "person")

            AlertDialog.Builder(this).run {
                setTitle("Confirm")
                setMessage("Do you wish to continue?")
                setPositiveButton("OK", eventHandler)
                setNegativeButton("Cancel", eventHandler)
                show()
            }

            true
        }
        "fold" -> {
            Log.d("kkang", "fold")
            true
            //super.onOptionsItemSelected(item)
        }

        else -> {
            Log.d("kkang", "${item.title} is real title")
            super.onOptionsItemSelected(item)
        }
    }



    val eventHandler = object : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            if(p1 == DialogInterface.BUTTON_POSITIVE) {
                Log.d("kkang", "positive button")
                //change to another activity

                val intent = Intent(applicationContext, EditProfileImageActivity::class.java)
                startActivity(intent)
            }
            else if(p1 == DialogInterface.BUTTON_NEGATIVE) {
                Log.d("kkang", "negative button")
            }
        }
    }
}