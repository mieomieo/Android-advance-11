package com.example.assignment1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.assignment1.adapter.FragmentAdapter
import com.example.assignment1.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = FragmentAdapter(this)
        binding.viewPager2.adapter = adapter


        val tabLayout = binding.tabLayout
        val viewPager2 = binding.viewPager2
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Page ${position+1}"
        }.attach()
    }
}