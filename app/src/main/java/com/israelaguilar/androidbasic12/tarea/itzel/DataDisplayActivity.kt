package com.israelaguilar.androidbasic12.tarea.itzel

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R

class DataDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_data_display)


        val name = intent.getStringExtra("USER_NAME")
        val lastname = intent.getStringExtra("USER_LASTNAME")
        val email = intent.getStringExtra("USER_EMAIL")
        val password = intent.getStringExtra("USER_PASSWORD")
        val gender = intent.getStringExtra("USER_GENDER")
        val month = intent.getStringExtra("USER_MONTH")

        findViewById<TextView>(R.id.tvNameOut).text = "Nombre: $name"
        findViewById<TextView>(R.id.tvLNameOut).text = "Apellido: $lastname"
        findViewById<TextView>(R.id.tvEmailOut).text = "$email"
        findViewById<TextView>(R.id.tvPasswordOut).text = "$password"
        findViewById<TextView>(R.id.tvGenderOut).text = "Sexo: $gender"
        findViewById<TextView>(R.id.tvMonthOut).text = "Mes de nacimiento: $month"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}