package com.weekfinal.h20185256.project_final

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.weekfinal.h20185256.project_final.databinding.ActivityMainPagerBinding
import com.weekfinal.h20185256.project_final.databinding.ItemRecyclerviewBinding

class MainPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pager)

        /*
        findViewById<LinearLayout>(R.id.pager_btn_first).setOnClickListener {
            val intent = Intent(this, FirstPortfolio::class.java)
            startActivity(intent)
            finish()
        }
         */
        /*
        val binding = ActivityMainPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.pager_btn_first, FirstPortfolio()).commit()
        supportFragmentManager.beginTransaction().add(R.id.pager_btn_second, SecondPortfolio()).commit()


        val contents = mutableListOf<String>()
        for (i in 1..20)
            contents.add("Item $i")

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerview?.layoutManager = layoutManager
        val adapter = MyAdapter(contents)
        binding.recyclerview?.adapter = adapter
        binding.recyclerview?.addItemDecoration(MyDecoration(this))

         */

    }
}
/*
class MyViewHolder(val binding : ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(val contents : MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return contents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = contents[position]
    }
}

class MyDecoration(val context : Context) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1

        if(index % 3 == 0)
            outRect.set(10, 10, 10, 60)
        else
            outRect.set(10, 10, 10, 0)

        view.setBackgroundColor(Color.parseColor("#28A0FF"))
        ViewCompat.setElevation(view, 20.0f)
    }
}

 */