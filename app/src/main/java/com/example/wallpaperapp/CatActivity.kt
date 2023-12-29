package com.example.wallpaperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wallpaperapp.Model.BomModel
import com.example.wallpaperapp.Model.CatModel
import com.example.wallpaperapp.adapter.CatAdapter
import com.example.wallpaperapp.adapter.CatImagesAdapter
import com.example.wallpaperapp.databinding.ActivityCatBinding
import com.google.firebase.firestore.FirebaseFirestore

class CatActivity : AppCompatActivity() {

    lateinit var binding:ActivityCatBinding
    lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")
        val name = intent.getStringExtra("name")

        db.collection("categories").document(uid!!).collection("wallpaper")
            .addSnapshotListener { value, error ->

            val listCatWallpapers = arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
                listCatWallpapers.addAll(data!!)

                binding.catTitle.text=name.toString()
                binding.catCount.text="${listCatWallpapers.size} Wallpapers availlable"

                binding.catRev.layoutManager=
                    StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                binding.catRev.adapter=CatImagesAdapter(this,listCatWallpapers)
        }

    }
}