package com.israelaguilar.androidbasic12.ejerciciofinal

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Recuperar datos
        val userName = intent.getStringExtra("USER_NAME")
        val userLastName = intent.getStringExtra("USER_LASTNAME")
        val userTitle = intent.getStringExtra("USER_TITLE")
        val userEmail = intent.getStringExtra("USER_EMAIL")
        val userSex = intent.getStringExtra("USER_SEX")
        val userPassword = intent.getStringExtra("USER_PASSWORD")

        val loginEmail = intent.getStringExtra("ARG_EMAIL")
        val loginPassword = intent.getStringExtra("ARG_PASSWORD")

        if (userName != null) {
            // Mostrar datos de registro
            binding.userDataSection.visibility = View.VISIBLE
            binding.loginDataSection.visibility = View.GONE

            binding.tvUserName.text = "Nombre: $userName"
            binding.tvUserLastName.text = "Apellido: $userLastName"
            binding.tvUserTitle.text = "Título: $userTitle"
            binding.tvUserEmail.text = "Correo: $userEmail"
            binding.tvUserSex.text = "Sexo: $userSex"
            binding.tvUserPassword.text = "Contraseña: $userPassword"
        } else if (loginEmail != null) {
            // Mostrar datos de login
            binding.userDataSection.visibility = View.GONE
            binding.loginDataSection.visibility = View.VISIBLE

            binding.tvUserEmailLogin.text = "Correo electrónico: $loginEmail"
            binding.tvUserPasswordLogin.text = "Contraseña: $loginPassword"
        } else {
            // Toast.makeText(this, "Únicas vistas disponibles", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}