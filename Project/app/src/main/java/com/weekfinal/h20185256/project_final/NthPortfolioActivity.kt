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
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weekfinal.h20185256.project_final.databinding.ActivityNthPortfolioBinding

class NthPortfolioActivity : AppCompatActivity() {
    lateinit var binding : ActivityNthPortfolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_nth_portfolio)

        binding = ActivityNthPortfolioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val tmpTitle = mutableListOf<String>()

        binding.nthBtnAdd.setOnClickListener {
            if(binding.nthEditText.text != null) {
                Log.d("kkang", "${binding.nthEditText.text}")
                tmpTitle.add(binding.nthEditText.text.toString())


                val layoutManager = LinearLayoutManager(this as Context) //부모의 context 찾기
                binding.nthPortfolioActivityRecyclerView.layoutManager = layoutManager
                val adapter = MyAdapter(tmpTitle)
                binding.nthPortfolioActivityRecyclerView.adapter = adapter
                binding.nthPortfolioActivityRecyclerView.addItemDecoration(
                    DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
                )

                binding.nthEditText.text = null
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.title){
        "person" -> {
            Log.d("kkang", "person")

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
                val intent = Intent(this, EditProfileImageActivity::class.java)
                startActivity(intent)
            }
            else if(p1 == DialogInterface.BUTTON_NEGATIVE) {
                Log.d("kkang", "negative button")
            }
        }
    }
}