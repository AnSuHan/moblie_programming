package com.weekfinal.h20185256.project_final

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weekfinal.h20185256.project_final.databinding.FragmentNthPortfolioBinding
import com.weekfinal.h20185256.project_final.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding : ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter (val contents : MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemDataTitle.text = contents!![position].substring(0 until 5)
        binding.itemDataMsg.text = contents!![position]
    }

    override fun getItemCount(): Int {
        return contents?.size ?: 0
    }
}