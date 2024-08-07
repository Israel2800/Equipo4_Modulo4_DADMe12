package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.actividad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R

class HomeComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_components)

        val imageBtnActivity1 = findViewById<ImageButton>(R.id.imageBtnActivity1)

        imageBtnActivity1.setOnClickListener {
            val intent = Intent(this, UpdateInformationActivity::class.java).apply {
            }
            startActivity(intent)

        }

    }
}
