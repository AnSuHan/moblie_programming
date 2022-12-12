package com.weekfinal.h20185256.project_final

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weekfinal.h20185256.project_final.databinding.FragmentNthPortfolioBinding
import com.weekfinal.h20185256.project_final.databinding.ItemRecyclerviewBinding
import kotlin.system.exitProcess

class MyViewHolder(val binding : ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

//NthPortfolio fragment에 사용하는 Adapter
class MyAdapter (val contents : MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(contents?.get(position) != null) {
            val binding = (holder as MyViewHolder).binding
            binding.itemDataTitle.text = contents!![position].substring(0 until 10)
            binding.itemDataMsg.text = contents!![position]
            binding.itemDataInfo.visibility = View.GONE
            binding.itemImg.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return contents?.size ?: 0
    }
}

//ContactActivity에 사용하는 Adapter
class MyAdapter2 (val contactCategory : MutableList<String>?, val contactDescription : MutableList<String>?, val contactInput : MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(contactCategory?.get(position) != null) {
            val binding = (holder as MyViewHolder).binding
            binding.itemDataTitle.text = contactCategory[position]
            binding.itemDataMsg.text = contactDescription!![position]
            binding.itemDataInfo.text = contactInput!![position]
        }
    }

    override fun getItemCount(): Int {
        return contactCategory?.size ?: 0
    }
}