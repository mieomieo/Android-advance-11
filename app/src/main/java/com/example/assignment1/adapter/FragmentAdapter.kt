package com.example.assignment1.adapter

import android.content.Context
import android.content.res.AssetManager
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assignment1.MainActivity
import com.example.assignment1.fragment.ImageFragment
import com.example.assignment1.model.Data
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class FragmentAdapter(fragment: FragmentActivity):FragmentStateAdapter(fragment) {
    private val dataImages = getObjectsFromJson(fragment.assets, "data.json", Data::class.java)
    override fun getItemCount(): Int = 5
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ImageFragment(dataImages.subList(0, 10))
            1 -> ImageFragment(dataImages.subList(10, 20))
            2 -> ImageFragment(dataImages.subList(20, 30))
            3 -> ImageFragment(dataImages.subList(30, 40))
            4 -> ImageFragment(dataImages.subList(40, 50))
            else -> Fragment()
        }
    }
    private fun <T> getObjectsFromJson(assetManager: AssetManager, path: String, tClassRef: Class<T>): List<T> {
        val jsonFileString = assetManager.open(path).bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, tClassRef)
        val adapter = moshi.adapter<List<T>>(listType)
        return jsonFileString.let { adapter.fromJson(it) } ?: ArrayList()
    }

}