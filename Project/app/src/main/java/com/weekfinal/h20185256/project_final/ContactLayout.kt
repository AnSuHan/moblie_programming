package com.weekfinal.h20185256.project_final

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.weekfinal.h20185256.project_final.databinding.ContactAddLayoutBinding

class ContactLayout : AppCompatActivity() {
    lateinit var binding : ContactAddLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        binding = ContactAddLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getContactText() : String{
        val str = binding.contactAddInput.text.toString()

        return str
    }
}