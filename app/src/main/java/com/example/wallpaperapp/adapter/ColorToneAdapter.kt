package com.example.wallpaperapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.Model.ColorToneModel
import com.example.wallpaperapp.R

class ColorToneAdapter(val requireContext: Context, val listTheColorTone: ArrayList<ColorToneModel>) : RecyclerView.Adapter<ColorToneAdapter.ColorToneViewHolder>() {

    inner class ColorToneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.bom_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorToneViewHolder {
        return ColorToneViewHolder(LayoutInflater.from(requireContext).inflate(R.layout.item_bom,parent,false))
    }

    override fun getItemCount(): Int {
        return listTheColorTone.size
    }

    override fun onBindViewHolder(holder: ColorToneViewHolder, position: Int) {
        Glide.with(requireContext).load(listTheColorTone[position].link).into(holder.imageView)
    }
}