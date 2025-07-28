package com.example.photogalleryapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photogalleryapp.databinding.ItemStorageBinding
import com.example.photogalleryapp.domain.model.PhotoDomain

class StorageItemAdapter :
    ListAdapter<PhotoDomain, StorageItemAdapter.MyViewHolder>
        (object : DiffUtil.ItemCallback<PhotoDomain>() {

        override fun areItemsTheSame(oldItem: PhotoDomain, newItem: PhotoDomain): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PhotoDomain, newItem: PhotoDomain): Boolean {
            return oldItem == newItem
        }
    }) {

    class MyViewHolder(val binding: ItemStorageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemStorageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = currentList[position]

        holder.binding.shimmerEffect.apply {

        }

        Glide.with(holder.binding.root)
            .load(photo.url)
            .centerCrop()
            .into(holder.binding.imageView)

    }

    override fun getItemCount(): Int = currentList.size

}