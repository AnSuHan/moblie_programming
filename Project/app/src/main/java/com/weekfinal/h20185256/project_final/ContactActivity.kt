package com.weekfinal.h20185256.project_final

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weekfinal.h20185256.project_final.databinding.ActivityContactBinding
import com.weekfinal.h20185256.project_final.databinding.ContactLayoutBinding

class ContactActivity : AppCompatActivity() {
    lateinit var binding : ActivityContactBinding
    val contactCategory = mutableListOf<String>()
    val contactDescription = mutableListOf<String>()
    val contactInput = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toolbar
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_contact_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.title){
        "back" -> {
            finish()

            true
        }
        "plus" -> {
            val contactAdd = ContactLayoutBinding.inflate(layoutInflater)

            AlertDialog.Builder(this).run {
                setView(contactAdd.root)
                setPositiveButton("SUBMIT", DialogInterface.OnClickListener { p0, p1 ->
                    if(p1 == DialogInterface.BUTTON_POSITIVE) {
                        contactCategory.add(contactAdd.contactCategory?.text.toString())
                        contactDescription.add(contactAdd.contactDescription.text.toString())
                        contactInput.add(contactAdd.contactAddInput.text.toString())
                    }

                    val layoutManager = LinearLayoutManager(applicationContext) //부모의 context 찾기
                    binding.contactRecyclerView.layoutManager = layoutManager
                    //val adapter = MyAdapter(tmpTitle)
                    binding.contactRecyclerView.adapter = MyAdapter2(contactCategory, contactDescription, contactInput)
                    binding.contactRecyclerView.addItemDecoration(
                        DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
                    )
                })
                setNegativeButton("CANCEL", null)
                show()
            }

            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}