package com.example.photogalleryapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photogalleryapp.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = StorageItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        var play=false
        binding.recyclerView.adapter = adapter
        binding.swipeRefreshLayout.setOnRefreshListener {

        }
        binding.swipeRefreshLayout.isRefreshing=false

        binding.modeAnim.setOnClickListener {
            binding.modeAnim.apply {
             if (play){
                 setMinAndMaxProgress(0.5f, 1f)
                 playAnimation()

                 play=false
              }
                else{
                 setMinAndMaxProgress(0.0f, .5f)
                 playAnimation()

                 play=true

             }

            }
        }
    }
}