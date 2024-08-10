package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        // Se generan instancias de botones
        val btnSend = findViewById<Button>(R.id.btnSend)
        val btnSendUrl = findViewById<Button>(R.id.btnSendUrl)

        btnSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso Urgente")
                putExtra(Intent.EXTRA_TEXT, "Este es un menssaje prueba de email.")
            }
            startActivity(Intent.createChooser(emailIntent, "Enviar email usando:"))
        }

        btnSendUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(Intent.createChooser(urlIntent, "Abrir usando: "))

        }
    }
}