package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.explicitintent.SecondActivity

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        // Colección de datos
        val list = findViewById<RecyclerView>(R.id.animalList)
        val data = listOf(AnimalEntity("León", "Amarillo", ""),
            AnimalEntity("Tigre", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Armadillo", "Amarillo", ""),
            AnimalEntity("Perro", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", ""))

        // Se crea instancia de Adaptador pasándole la colección de datos
        val adapter = AnimalAdapter(data)

        adapter.onItemSelected = {animal ->
            when(animal.name){
                "Perro" ->{
                    val detailIntent = Intent(this, SecondActivity::class.java).apply {
                        putExtra("EXTRA_ANIMAL", animal)
                    }
                    startActivity(detailIntent)
                }
                else ->{
                    val detailIntent = Intent(this, AnimalDetailActivity::class.java).apply {
                        putExtra("EXTRA_ANIMAL", animal)
                    }
                    startActivity(detailIntent)
                }

            }

            /*if(animal.name == "Perro"){
                val detailIntent = Intent(this, AnimalDetailActivity::class.java).apply {
                    putExtra("EXTRA_ANIMAL", animal)
                }
                startActivity(detailIntent)
            }else{
                val detailIntent = Intent(this, AnimalDetailActivity::class.java).apply {
                    putExtra("EXTRA_ANIMAL", animal)
                }
                startActivity(detailIntent)
            }*/

            // Toast.makeText(this, "Name: ${animal.name}", Toast.LENGTH_LONG).show()
        }

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // list.layoutManager = GridLayoutManager(this, 1)
    }
}