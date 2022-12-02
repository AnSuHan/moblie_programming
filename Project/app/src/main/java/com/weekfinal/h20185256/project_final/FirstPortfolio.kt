package com.weekfinal.h20185256.project_final

import android.content.Context
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weekfinal.h20185256.project_final.databinding.FragmentFirstPortfolioBinding

class FirstPortfolio : Fragment() {
    lateinit var binding : FragmentFirstPortfolioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //binding = FragmentFirstPortfolioBinding.inflate(layoutInflater)

        //return binding.root
        return inflater.inflate(R.layout.fragment_first_portfolio, container, false)
    }
}

