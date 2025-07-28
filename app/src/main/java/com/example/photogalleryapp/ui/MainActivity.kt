package com.example.photogalleryapp.ui


import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.photogalleryapp.data.mappers.toDomain
import com.example.photogalleryapp.data.repository_impl.view_model.GalleryViewModel
import com.example.photogalleryapp.data.repository_impl.view_model.StateShow
import com.example.photogalleryapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var play = false
    private var currentNightMode: Int = 0
    private lateinit var binding: ActivityMainBinding
    private val adapter = StorageItemAdapter()
    private val viewModel: GalleryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeAnim()
        initListeners()
        viewModel.loadPhotos()
        observe()
    }

    private fun changeAnim() {
        currentNightMode =
            resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            binding.modeAnim.setMinAndMaxProgress(0f, .5f)
            binding.modeAnim.progress = 0.5f
            binding.modeAnim.playAnimation()
            play = false
        }
        else{
            binding.modeAnim.setMinAndMaxProgress(0.5f, 1f)
            binding.modeAnim.progress = 0.5f
            binding.modeAnim.playAnimation()
            play = true
        }
    }

    private fun observe() {
        viewModel.stateShow.observe(this) { state ->
            when (state) {
                is StateShow.Error -> {
                    showError(state.message)
                }

                StateShow.Loading -> {}

                is StateShow.Success -> {
                    binding.swipeRefreshLayout.isRefreshing = false
                    adapter.submitList(state.photos.toList())
                }

                is StateShow.Offline -> {
                    binding.swipeRefreshLayout.isRefreshing = false
                    adapter.submitList(state.photos.toList())
                    Toast.makeText(this, "no Internet connection", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun initListeners() {

        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.itemAnimator = null

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.loadPhotos()
        }

        binding.modeAnim.setOnClickListener {
            binding.modeAnim.apply {
                if (play) {
                    setMinAndMaxProgress(0f, 0.5f)
                    playAnimation()
                    play = false
                } else {
                    setMinAndMaxProgress(0.5f, 1f)
                    playAnimation()
                    play = true
                }
            }


            binding.modeAnim.postDelayed({

                if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }, 300)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("play", play)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        play = savedInstanceState.getBoolean("play")
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun showError(message: String) {
        AlertDialog.Builder(this).apply {
            setTitle("Error")
            setMessage(message )
            setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
        }.create().show()
    }
}