package com.example.assignment1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment1.R
import com.example.assignment1.databinding.ItemImgBinding
import com.example.assignment1.model.Data

class ImageAdapter(private val data: List<Data>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemImgBinding = ItemImgBinding.bind(view)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_img, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        Glide.with(holder.binding.image.context).load(data[position].url)
            .error(R.drawable.ic_launcher_foreground).into(holder.binding.image)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}