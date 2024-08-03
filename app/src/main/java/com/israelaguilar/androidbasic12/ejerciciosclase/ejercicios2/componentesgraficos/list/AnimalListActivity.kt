package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos.list

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.androidbasic12.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val list = findViewById<RecyclerView>(R.id.animalList)
        val data = listOf(AnimalEntity("León", "Amarillo", ""),
            AnimalEntity("Tigre", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Armadillo", "Amarillo", ""),
            AnimalEntity("Perro", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", ""))

        val adapter = AnimalAdapter(data)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // list.layoutManager = GridLayoutManager(this, 1)
    }
}