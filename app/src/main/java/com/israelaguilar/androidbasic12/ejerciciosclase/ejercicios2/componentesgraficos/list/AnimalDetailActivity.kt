package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos.list

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R

class AnimalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)

        val tvAnimalName = findViewById<TextView>(R.id.tvAnimalName)
        val animal = intent.getSerializableExtra("EXTRA_ANIMAL") as AnimalEntity

        tvAnimalName.text = animal.name
    }
}