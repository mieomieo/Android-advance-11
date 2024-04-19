package com.example.assignment1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assignment1.adapter.ImageAdapter
import com.example.assignment1.databinding.FragmentImgBinding
import com.example.assignment1.model.Data

class ImageFragment(private val listImage:List<Data>) : Fragment() {

    private lateinit var binding: FragmentImgBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentImgBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvImage.layoutManager = GridLayoutManager(context,2)
        val adapter = ImageAdapter(listImage)
        binding.rvImage.adapter = adapter
    }

}