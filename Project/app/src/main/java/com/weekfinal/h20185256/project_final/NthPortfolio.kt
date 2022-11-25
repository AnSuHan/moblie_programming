package com.weekfinal.h20185256.project_final

import android.R
import android.content.Context
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weekfinal.h20185256.project_final.databinding.FragmentNthPortfolioBinding


class NthPortfolio : Fragment() {
    lateinit var binding : FragmentNthPortfolioBinding
    var count = 0
    val tmp_title = mutableListOf<String>("title1", "title2", "title3")
    val tmp_msg = mutableListOf<String>("msg1", "msg2", "msg3")
    override fun onAttach(context: Context) {
        super.onAttach(context)

        binding = context as FragmentNthPortfolioBinding        //오류
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentNthPortfolioBinding.inflate(layoutInflater)





        val layoutManager = LinearLayoutManager(this as Context) //부모의 context 찾기
        binding.nthPortfolioRecyclerView.layoutManager = layoutManager
        val adapter = MyAdapter(tmp_title)
        binding.nthPortfolioRecyclerView.adapter = adapter
        binding.nthPortfolioRecyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        binding.nthBtnAdd.setOnClickListener {
            val str = binding.nthEditText.text.toString()

            if(str != null) {
                when(count) {
                    0 -> {
                        binding.nthFirstLayout.visibility = View.VISIBLE
                        binding.nthFirstText.text = binding.nthEditText.text
                        binding.nthFirstTitle.text = binding.nthFirstText.toString().substring(0 until 10)
                        }



                }
                count++
            }
        }

         */

        return super.onCreateView(inflater, container, savedInstanceState)
    }



}