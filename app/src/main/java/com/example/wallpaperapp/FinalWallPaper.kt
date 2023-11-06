package com.example.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wallpaperapp.databinding.ActivityFinalWallPaperBinding
import com.example.wallpaperapp.databinding.ActivityMainBinding

class FinalWallPaper : AppCompatActivity() {

    lateinit var binding: ActivityFinalWallPaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalWallPaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("link")

        //setting wallpaper in @+id/finalWallPaper
        Glide.with(this).load(url).into(binding.finalWallPaper)

        binding.btnDownload.setOnClickListener {

        }

        binding.btnSetWallpaper.setOnClickListener {

        }
    }
}