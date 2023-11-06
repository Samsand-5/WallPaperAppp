package com.example.wallpaperapp

import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.wallpaperapp.databinding.ActivityFinalWallPaperBinding
import com.google.firebase.inject.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.File
import java.io.IOException
import java.io.OutputStream
import java.net.URL
import java.util.*

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

    private fun saveImage(image: Bitmap?) {
        val random1 = Random().nextInt(520985)
        val random2 = Random().nextInt(952663)

        val name = "AMOLED-${random1 + random2}"

        val data: OutputStream
        try {
            val resolver = contentResolver
            val contentValues = ContentValues()
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "$name.jpg")
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
            contentValues.put(
                MediaStore.MediaColumns.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES + File.separator + "Amoled Wallpaper"
            )
            val imageUri =
                resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues)
            data = resolver.openOutputStream(Objects.requireNonNull(imageUri!!))!!
            image?.compress(Bitmap.CompressFormat.JPEG,100,data)
            Objects.requireNonNull<OutputStream>(data)
            Toast.makeText(this,"Image is Saved",Toast.LENGTH_SHORT).show()
        } catch (e: Exception){
            Toast.makeText(this,"Image Not Saved",Toast.LENGTH_SHORT).show()
        }
    }

    fun URL.toBitmap(url: String?): Bitmap? {
        return try {
            BitmapFactory.decodeStream(openStream())
        } catch (e: IOException) {
            null
        }
    }
}
