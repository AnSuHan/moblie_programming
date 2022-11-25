package com.weekfinal.h20185256.project_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.weekfinal.h20185256.project_final.databinding.ActivityEditProfileImageBinding

class EditProfileImageActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditProfileImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_edit_profile_image)
        binding = ActivityEditProfileImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editProfileImageView.setOnClickListener {
            onBackPressed()
        }
    }
}