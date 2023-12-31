package com.example.wallpaperapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.Model.ColorToneModel
import com.example.wallpaperapp.R

class ColorToneAdapter(val requireContext: Context, val listTheColorTone: ArrayList<ColorToneModel>) : RecyclerView.Adapter<ColorToneAdapter.ColorToneViewHolder>() {

    inner class ColorToneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cardBack = itemView.findViewById<CardView>(R.id.item_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorToneViewHolder {
        return ColorToneViewHolder(LayoutInflater.from(requireContext).inflate(R.layout.item_tct,parent,false))
    }

    override fun getItemCount(): Int {
        return listTheColorTone.size
    }

    override fun onBindViewHolder(holder: ColorToneViewHolder, position: Int) {
        val color = listTheColorTone[position].color
        holder.cardBack.setCardBackgroundColor(Color.parseColor(color!!))
    }
}