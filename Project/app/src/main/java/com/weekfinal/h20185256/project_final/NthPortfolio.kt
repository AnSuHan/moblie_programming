package com.weekfinal.h20185256.project_final

import android.R
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.weekfinal.h20185256.project_final.databinding.FragmentNthPortfolioBinding


class NthPortfolio : Fragment() {
    lateinit var binding : FragmentNthPortfolioBinding
    //lateinit var toggle : ActionBarDrawerToggle
    var tmpTitle : MutableList<String> = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentNthPortfolioBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //toolbar
        //setSupportActionBar(binding.toolbar)

        //toggle 버튼 적용
        //toggle = ActionBarDrawerToggle(this, binding.drawer2, com.weekfinal.h20185256.project_final.R.string.drawer_opened, com.weekfinal.h20185256.project_final.R.string.drawer_closed)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)   // 왼쪽 버튼 사용 여부 true
        //toggle.syncState()

        //binding.drawer2.addDrawerListener(toggle)

        //var drawerLayout = findViewById<DrawerLayout>(com.weekfinal.h20185256.project_final.R.id.drawer2)

        /*
        binding.nthBtnAdd.setOnClickListener {
            Log.d("kkang", "nthBtnAdd in onCreate : ${binding.nthEditText.text.toString()}")

            if(binding.nthEditText.text != null) {
                Log.d("kkang", "${binding.nthEditText.text}")
                tmpTitle.add(binding.nthEditText.text.toString())


                val layoutManager = LinearLayoutManager(this as Context) //부모의 context 찾기
                binding.nthPortfolioActivityRecyclerView.layoutManager = layoutManager
                //val adapter = MyAdapter(tmpTitle)
                binding.nthPortfolioActivityRecyclerView.adapter = MyAdapter(tmpTitle)
                binding.nthPortfolioActivityRecyclerView.addItemDecoration(
                    DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
                )

                binding.nthEditText.text = null
            } else {
                Log.d("kkang", "text is null")
            }
        }
         */

        /*
        binding.mainDrawerView?.findViewById<Button>(R.id.navigation_returnIntro)?.setOnClickListener {
            Toast.makeText(this, "click btn_returnIntro", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.mainDrawerView?.findViewById<Button>(R.id.navigation_collapse)?.setOnClickListener {
            Toast.makeText(this, "click btn_collapse", Toast.LENGTH_SHORT).show()
        }
         */

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNthPortfolioBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nthBtnAdd.setOnClickListener {
            Log.d("kkang", "nthBtnAdd in onViewCreated : ${binding.nthEditText.text.toString()}")

            tmpTitle.add(binding.nthEditText.text.toString())


            val layoutManager = LinearLayoutManager(requireContext())
            binding.nthPortfolioRecyclerView.layoutManager = layoutManager
            binding.nthPortfolioRecyclerView.adapter = MyAdapter(tmpTitle)
            binding.nthPortfolioRecyclerView.addItemDecoration(
                DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            )


            binding.nthEditText.text = null
        }

        binding.navigationBtnContact.setOnClickListener {
            val intent = Intent(requireContext(), ContactActivity::class.java)
            startActivity(intent)
        }
    }
}