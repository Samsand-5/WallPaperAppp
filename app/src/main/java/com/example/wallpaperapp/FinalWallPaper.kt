package com.example.wallpaperapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wallpaperapp.databinding.ActivityFinalWallPaperBinding
import com.google.firebase.inject.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.URL

class FinalWallPaper : AppCompatActivity() {

    lateinit var binding: ActivityFinalWallPaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalWallPaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("link")

        val urlImage = URL(url)

        //setting wallpaper in @+id/finalWallPaper
        Glide.with(this).load(url).into(binding.finalWallPaper)

        binding.btnDownload.setOnClickListener {
            val result: kotlinx.coroutines.Deferred<Bitmap?> = GlobalScope.async {
                urlImage.toBitmap(url)
            }

            GlobalScope.launch(Dispatchers.Main) {
                saveImage(result.await())
            }
        }

        binding.btnSetWallpaper.setOnClickListener {

        }
    }

    private fun saveImage(await: Bitmap?) {

    }

    fun URL.toBitmap(url: String?): Bitmap? {
        return try {
            BitmapFactory.decodeStream(openStream())
        } catch (e: IOException) {
            null
        }
    }
}
