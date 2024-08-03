package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.androidbasic12.R

class PersonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        val list = findViewById<RecyclerView>(R.id.personList)
        val data = listOf(PersonEntity("Paola", "Delgadillo", ""),
            PersonEntity("Julieta", "Aguilar", ""),
            PersonEntity("Romeo", "Aguilar", ""),
            PersonEntity("Israel", "Aguilar", ""),
            PersonEntity("Itzel", "Valdeolivar", ""),
            PersonEntity("Alan", "Espinosa", ""))

        val adapter = PersonAdapter(data)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // list.layoutManager = GridLayoutManager(this, 1)
    }
}