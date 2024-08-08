package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.actividad

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val labelNameActivity4 = findViewById<TextView>(R.id.labelNameActivity4)
        val btnSendUrlGitHub = findViewById<Button>(R.id.btnSendUrlGitHub)
        val btnReturnActivity4Info = findViewById<Button>(R.id.btnReturnActivity4Info)

        btnSendUrlGitHub.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Israel2800/Equipo4_Modulo4_DADMe12"))
            startActivity(Intent.createChooser(urlIntent, "Abrir usando: "))
            Toast.makeText(this, "Abriendo repositorio", Toast.LENGTH_LONG).show()
        }

        intent.extras?.let { extras ->
            if(extras.containsKey("EXTRA_USERNAME")){
                val userName = extras.getString("EXTRA_USERNAME", "")
                labelNameActivity4.text = "GitHub Username: $userName"
            }
        }

        btnReturnActivity4Info.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT_KEY", true)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }
}