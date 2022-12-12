package com.weekfinal.h20185256.project_final

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weekfinal.h20185256.project_final.databinding.FragmentNthPortfolioBinding


class NthPortfolio : Fragment() {
    lateinit var binding : FragmentNthPortfolioBinding
    var tmpTitle : MutableList<String> = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentNthPortfolioBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNthPortfolioBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nthBtnAdd.setOnClickListener {
            tmpTitle.add(binding.nthEditText.text.toString())


            val layoutManager = LinearLayoutManager(requireContext())
            binding.nthPortfolioRecyclerView.layoutManager = layoutManager
            binding.nthPortfolioRecyclerView.adapter = MyAdapter(tmpTitle)
            binding.nthPortfolioRecyclerView.addItemDecoration(
                DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            )

            binding.nthEditText.text = null
        }
    }
}