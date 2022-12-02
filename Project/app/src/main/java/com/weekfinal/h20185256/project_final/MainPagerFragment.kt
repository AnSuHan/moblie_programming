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

    //source : https://juahnpop.tistory.com/215
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

        binding.pagerBtnFirst.setOnClickListener {
            Log.d("kkang", "success fragment binding")
        }
    }
}