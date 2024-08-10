package com.israelaguilar.androidbasic12.tarea.israel

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R

class UserDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Obtener los datos del intent
        val userName = intent.getStringExtra("USER_NAME")
        val userLastName = intent.getStringExtra("USER_LASTNAME")
        val userTitle = intent.getStringExtra("USER_TITLE")
        val userEmail = intent.getStringExtra("USER_EMAIL")
        val userSex = intent.getStringExtra("USER_SEX")
        val userPassword = intent.getStringExtra("USER_PASSWORD")

        // Mostrar datos en interfaz
        findViewById<TextView>(R.id.tvUserName).text = "Nombre: $userName"
        findViewById<TextView>(R.id.tvUserLastName).text = "Apellido: $userLastName"
        findViewById<TextView>(R.id.tvUserTitle).text = "Título: $userTitle"
        findViewById<TextView>(R.id.tvUserEmail).text = "Correo electrónico: $userEmail"
        findViewById<TextView>(R.id.tvUserPassword).text = "Contraseña: $userPassword"
        findViewById<TextView>(R.id.tvUserSex).text = "Sexo: $userSex"

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