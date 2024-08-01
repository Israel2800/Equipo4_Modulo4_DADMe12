package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.actividad

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnSendEmail = findViewById<Button>(R.id.btnSendEmail)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnCall.setOnClickListener {
            val phoneNumber = "+16154010212"
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(callIntent)
            Toast.makeText(this, "Llamando a $phoneNumber", Toast.LENGTH_LONG).show()
        }

        btnSendEmail.setOnClickListener {
            val recipient = "dady281100@gmail.com"
            val subject = "Asunto del correo"
            val message = "Contenido del correo"

            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
            }

            try {
                startActivity(Intent.createChooser(emailIntent, "Enviar correo usando:"))
            } catch (e: android.content.ActivityNotFoundException) {
                Toast.makeText(this, "No hay clientes de correo instalados.", Toast.LENGTH_SHORT).show()
            }
        }

        btnReturn.setOnClickListener {
            val resultIntent = Intent().apply{
                putExtra("EXTRA_IS_CORRECT_KEY", true)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}