package com.israelaguilar.androidbasic12.tarea

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.actividad.ConfigurationActivity
import com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.actividad.UpdateInformationActivity
import com.israelaguilar.androidbasic12.tarea.israel.UserSignUpActivity
import com.israelaguilar.androidbasic12.tarea.itzel.DataDisplayActivity
import com.israelaguilar.androidbasic12.tarea.itzel.SingUpActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val imageBtnIsrael = findViewById<ImageButton>(R.id.imageBtnIsrael)
        val imageBtnItzel = findViewById<ImageButton>(R.id.imageBtnItzel)
        val tvIsrael = findViewById<TextView>(R.id.tvIsrael)
        val tvItzel = findViewById<TextView>(R.id.tvItzel)

        imageBtnIsrael.setOnClickListener {
            val intent = Intent(this, UserSignUpActivity::class.java).apply {
            }
            startActivity(intent)
        }


        tvIsrael.setOnClickListener {
            val intent = Intent(this, UserSignUpActivity::class.java).apply {
            }
            startActivity(intent)
        }


        imageBtnItzel.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java).apply {
            }
            startActivity(intent)
        }


        tvItzel.setOnClickListener {
            val intent2 = Intent(this, SingUpActivity::class.java).apply {
            }
            startActivity(intent2)
        }
    }
}