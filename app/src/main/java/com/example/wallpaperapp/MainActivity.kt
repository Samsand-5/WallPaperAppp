package com.example.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.wallpaperapp.Fragments.DownloadFragment
import com.example.wallpaperapp.Fragments.HomeFragment
import com.example.wallpaperapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.icHome.setOnClickListener{
            replaceFragment(HomeFragment())
        }

        binding.icDownload.setOnClickListener{
            replaceFragment(DownloadFragment())
        }
    }
    fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().add(R.id.fragmentReplace,fragment).commit()
    }
}