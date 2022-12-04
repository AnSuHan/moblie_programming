package com.weekfinal.h20185256.project_final

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.weekfinal.h20185256.project_final.databinding.ActivityContactLayoutBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class ContactLayout : AppCompatActivity() {
    lateinit var binding : ActivityContactLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        binding = ActivityContactLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.contactAddInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("kkang", "listener beforeTextChanged")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("kkang", "listener onTextChanged")
                binding.contactTextview?.text = binding.contactAddInput.text

                runOnUiThread {
                    Log.d("kkang", "textChange runOnUiThread")
                }
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("kkang", "listener afterTextChanged")
                Log.d("kkang", "${s.toString()}")
            }
       })



        /*
        GlobalScope.launch {
            Log.d("kkang", "globalscope coroutine")
            delay(1000)
        }
        Log.d("kkang", "after launch")
        */

        //Log.d("kkang", "layout : ${binding.contactAddInput.text.toString()}")
        /*
        thread() {
            Log.d("kkang","${Thread.currentThread()}: it's running.")
        }
         */
        /*
        val thread = MyThread()
        thread.start()

        Thread() {
            Log.d("kkang", "layout thread")
        }.start()

        object : Thread() {
            override fun run() {
                super.run()
                Log.d("kkang", "object thread")
            }
        }
         */
    }



    override fun onPause() {
        Log.d("kknag", "onPause")

        super.onPause()
    }

    override fun onStop() {
        Log.d("kkang", "onStop")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d("kkang", "onDestroy")

        super.onDestroy()
    }


    public fun getContactText() : String{
        val str = binding.contactAddInput.text.toString()

        return str
    }
}