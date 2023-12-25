package com.example.wallpaperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.Model.CatModel
import com.example.wallpaperapp.adapter.CatAdapter
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

        db.collection("categories").document(uid!!).collection("wallpaper")
            .addSnapshotListener { value, error ->

            val listCategories = arrayListOf<CatModel>()
            val data = value?.toObjects(CatModel::class.java)
            listCategories.addAll(data!!)

        }

    }
}