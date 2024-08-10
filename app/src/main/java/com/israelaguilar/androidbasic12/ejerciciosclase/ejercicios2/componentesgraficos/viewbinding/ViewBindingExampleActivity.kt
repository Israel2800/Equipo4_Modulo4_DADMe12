package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos.viewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.ActivityViewBindingExampleBinding

class ViewBindingExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBindingExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvFinal.text = "Texto final"
        binding.tvName.text = "Israel"
        binding.tvSurname.text = "n/a"
        binding.tvLastName.text = "Aguilar"


    }
}