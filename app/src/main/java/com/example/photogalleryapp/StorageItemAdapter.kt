package com.example.photogalleryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.photogalleryapp.databinding.ItemStorageBinding
import com.example.photogalleryapp.model.Photo

class StorageItemAdapter :
    ListAdapter<Photo, StorageItemAdapter.MyViewHolder>
        (object : DiffUtil.ItemCallback<Photo>() {

        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }) {

    class MyViewHolder(val binding: ItemStorageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemStorageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.shimmerEffect.apply {
            startShimmer()
            isVisible = true
            showShimmer(true)
        }
    }

    override fun getItemCount(): Int =5

}