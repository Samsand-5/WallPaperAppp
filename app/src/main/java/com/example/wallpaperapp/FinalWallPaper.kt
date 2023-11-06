package com.example.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wallpaperapp.databinding.ActivityFinalWallPaperBinding
import com.example.wallpaperapp.databinding.ActivityMainBinding

class FinalWallPaper : AppCompatActivity() {

    lateinit var binding: ActivityFinalWallPaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalWallPaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("link")

        binding.btnDownload.setOnClickListener {

        }

        binding.btnSetWallpaper.setOnClickListener {

        }
    }
}