package com.example.wallpaperapp.Fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.FragmentDownloadBinding
import java.io.File


class DownloadFragment : Fragment() {

    lateinit var binding: FragmentDownloadBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDownloadBinding.inflate(layoutInflater,container,false)

        val allFiles : Array<File>
        val imageList = arrayListOf<String>()

        val targetPath =
            Environment.getExternalStorageDirectory().absolutePath+"/Pictures/Amoled wallpaper"

        val targetFiles = File(targetPath)
        allFiles = targetFiles.listFiles()!!

        return binding.root
    }

}