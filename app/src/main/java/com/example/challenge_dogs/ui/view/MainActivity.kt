package com.example.challenge_dogs.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.challenge_dogs.R
import com.example.challenge_dogs.databinding.ActivityMainBinding
import com.example.challenge_dogs.ui.adapter.DogAdapter
import com.example.challenge_dogs.ui.viewModel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val dogViewModel:DogViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        dogViewModel.getDogs()
        dogViewModel.listDog.observe(this,{ dogs ->
            binding.rvDog.adapter= DogAdapter(dogs)
        })

        setContentView(binding.root)
    }
}