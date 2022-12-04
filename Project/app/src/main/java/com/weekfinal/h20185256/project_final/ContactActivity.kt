package com.weekfinal.h20185256.project_final

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weekfinal.h20185256.project_final.databinding.ActivityContactBinding
import com.weekfinal.h20185256.project_final.databinding.ActivityContactLayoutBinding

class ContactActivity : AppCompatActivity() {
    lateinit var binding : ActivityContactBinding
    lateinit var inputStr : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_contact)

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
            Log.d("kkang", "back")
            finish()

            true
        }
        "plus" -> {
            Log.d("kkang", "plus")
            val contactAdd = ActivityContactLayoutBinding.inflate(layoutInflater)

            AlertDialog.Builder(this).run {
                val newBinding = ActivityContactLayoutBinding.inflate(layoutInflater)
                Thread() {
                    textCheck()
                }.run()


                setView(contactAdd.root)
                setPositiveButton("SUBMIT", eventHandler)
                setNegativeButton("CANCEL", null)
                show()
            }

            true
        }

        else -> {
            Log.d("kkang", "${item.title} is real title")
            super.onOptionsItemSelected(item)
        }
    }

    val contactList = mutableListOf<String>()

    val eventHandler = object : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            if(p1 == DialogInterface.BUTTON_POSITIVE) {
                Log.d("kkang", "positive button")

                val newBinding = ActivityContactLayoutBinding.inflate(layoutInflater)

                Log.d("kkang", "${newBinding.toString()}")
                Log.d("kkang", "${newBinding.contactAddInput.toString()}")
                Log.d("kkang", "${newBinding.contactAddInput.text.toString()}")
                Log.d("kkang", "${newBinding.contactAddInput.getText()}")


                runOnUiThread {
                    Log.d("kkang", "activity runOnThread ${newBinding.contactAddInput.text.toString()}")
                }

                /*
                Thread() {
                    Log.d("kkang", "activity thread")
                    Thread.sleep(1000)

                    runOnUiThread {
                        Log.d("kkang", "activity thread ${newBinding.contactAddInput.text.toString()}")
                    }
                }.run()
                 */


                //contactList.add(newBinding.contactAddInput.text.toString())

                /*
                inputStr = findViewById<EditText>(R.id.contact_add_input).toString()        //not working
                Log.d("kkang", "new var data : ${inputStr}")

                 */
                /*
                inputStr = findViewById<EditText>(R.id.contact_add_input).text.toString()
                Log.d("kkang", "new var data : ${inputStr}")


                val str : String = ContactAddLayoutBinding.inflate(layoutInflater).contactAddInput.text.toString()     //not working
                Log.d("kkang", "${str}")

                var str2 = ActivityContactLayoutBinding.inflate(layoutInflater).contactAddInput.text.toString()         //not working
                Log.d("kkang", "${str2}")
                 */


                //
                /*
                val contactAddBinding = ContactAddLayoutBinding.inflate(layoutInflater)
                inputStr = contactAddBinding.contactAddInput.text.toString()    //not working
                */
                /*
                var bindingContact = ContactAddLayoutBinding.inflate(layoutInflater)

                val str = bindingContact.contactAddInput.text.toString()
                */
                /*
                var contactLayout = ContactLayout()
                val str = contactLayout.getContactText()

                Log.d("kkang", "inflate ${str}")
                Log.d("kkang", contactLayout.getContactText())
                */



                //contactList.add(inputStr)
            }


            val layoutManager = LinearLayoutManager(applicationContext) //부모의 context 찾기
            binding.contactRecyclerView.layoutManager = layoutManager
            //val adapter = MyAdapter(tmpTitle)
            binding.contactRecyclerView.adapter = MyAdapter2(contactList)
            binding.contactRecyclerView.addItemDecoration(
                DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            )
        }
    }

    fun textCheck() {
        val newBinding = ActivityContactLayoutBinding.inflate(layoutInflater)
        Log.d("kkang", "activity thread")
        Log.d("kkang", "activity thread ${newBinding.contactAddInput.text.toString()}")
    }
}