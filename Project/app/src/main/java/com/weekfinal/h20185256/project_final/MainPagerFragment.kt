package com.weekfinal.h20185256.project_final

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weekfinal.h20185256.project_final.databinding.FragmentMainPagerBinding

class MainPagerFragment : Fragment() {
    lateinit var binding :FragmentMainPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPagerBinding.inflate(inflater, container, false)

        return binding.root

        //return inflater.inflate(R.layout.fragment_main_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //"Should Be BackUp!!" -> if use intent in listener : can't restore this project
        //when rewrite in this code
        binding.pagerBtnFirst.setOnClickListener {
            Log.d("kkang", "first btn clicked")
        }
        binding.pagerBtnSecond.setOnClickListener {
            Log.d("kkang", "second btn clicked")
        }
        binding.pagerBtnThird.setOnClickListener {
            Log.d("kkang", "third btn clicked")
        }
        binding.pagerBtnNth.setOnClickListener {
            Log.d("kkang", "nth btn clicked")
        }
    }
}