package com.example.wallpaperapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.Model.BomModel
import com.example.wallpaperapp.R

class BomAdapter(val requireContext: Context, val listBestOfTheMonth: ArrayList<BomModel>) : RecyclerView.Adapter<BomAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(LayoutInflater.from(requireContext).inflate(R.layout.item_bom,parent,false))
    }

    override fun getItemCount(): Int {
        return listBestOfTheMonth.size
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

    }
}