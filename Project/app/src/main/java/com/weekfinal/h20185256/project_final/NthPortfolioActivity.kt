package com.weekfinal.h20185256.project_final

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SettingsSlicesContract
import android.util.Log
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
}