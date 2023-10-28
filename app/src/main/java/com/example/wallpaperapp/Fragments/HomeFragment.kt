package com.example.wallpaperapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaperapp.Model.BomModel
import com.example.wallpaperapp.Model.ColorToneModel
import com.example.wallpaperapp.Model.CatModel
import com.example.wallpaperapp.adapter.BomAdapter
import com.example.wallpaperapp.adapter.CatAdapter
import com.example.wallpaperapp.adapter.ColorToneAdapter
import com.example.wallpaperapp.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var db: FirebaseFirestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        db = FirebaseFirestore.getInstance()

        db.collection("bestofmonth").addSnapshotListener { value, error ->
            val listBestOfTheMonth = arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
            listBestOfTheMonth.addAll(data!!)

            binding.rcvBom.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcvBom.adapter = BomAdapter(requireContext(),listBestOfTheMonth)
        }


        db.collection("thecolortone").addSnapshotListener { value, error ->
            val listTheColorTone = arrayListOf<ColorToneModel>()
            val data = value?.toObjects(ColorToneModel::class.java)
            listTheColorTone.addAll(data!!)

            binding.rcvTct.layoutManager =
                LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.rcvTct.adapter = ColorToneAdapter(requireContext(), listTheColorTone)
        }


        db.collection("categories").addSnapshotListener { value, error ->
            val listCategories = arrayListOf<CatModel>()
            val data = value?.toObjects(CatModel::class.java)
            listCategories.addAll(data!!)

            binding.rcvCat.layoutManager =
                GridLayoutManager(requireContext(),2)
            binding.rcvCat.adapter = CatAdapter(requireContext(), listCategories)
        }

        return binding.root
    }

}
