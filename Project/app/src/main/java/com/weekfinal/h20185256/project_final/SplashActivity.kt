package com.weekfinal.h20185256.project_final

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progress = findViewById<ProgressBar>(R.id.splash_progress)
        Thread {
            while(true) {
                progress.setProgress(progress.progress + 100/3)
                Thread.sleep(1000)
            }
        }.start()

        Handler().postDelayed({
            val intent = Intent(this, MainPagerActivity2::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}