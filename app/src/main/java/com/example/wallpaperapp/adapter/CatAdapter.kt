package com.example.wallpaperapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.Model.CatModel
import com.example.wallpaperapp.R

class CatAdapter(val requireContext: Context, val listCategories: ArrayList<CatModel>) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.bom_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(LayoutInflater.from(requireContext).inflate(R.layout.item_cat,parent,false))
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        Glide.with(requireContext).load(listCategories[position].link).into(holder.imageView)
    }
}