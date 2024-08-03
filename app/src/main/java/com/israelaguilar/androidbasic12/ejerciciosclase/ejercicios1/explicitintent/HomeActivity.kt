package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.explicitintent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.R.id.btnSendActivity4
import com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.actividad.FifthActivity
import com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.actividad.FourthActivity

class HomeActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK){
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY", false)
            if(isCorrect == true){
                onBackPressedDispatcher.onBackPressed()
            }else{
                Toast.makeText(this, "resultExtra= $isCorrect", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity)
        val btnSendActivity3 = findViewById<Button>(R.id.btnSendActivity3)
        val btnSendActivity4 = findViewById<Button>(R.id.btnSendActivity4)
        val btnSendActivity5 = findViewById<Button>(R.id.btnSendActivity5)

        btnSendActivity.setOnClickListener {

            //Se crea un bundle con infomación extra y se envia bundle como extra en intent
            val extraBundle = Bundle().apply {
                putString("EXTRA_SURNAME", "Aguilar")
                putBoolean("EXTRA_MARRIED", true)
            }

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Israel")
                putExtra("EXTRA_AGE_KEY", 23)
                putExtra("EXTRA_MORE_INFO", extraBundle)
            }

            register.launch(intent)
            // startActivity(intent)

        }

        // Calling third activity
        btnSendActivity3.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Israel")
                putExtra("EXTRA_OPTION", true)
            }

            startActivity(intent)
        }

        // Calling fourth activity
        btnSendActivity4.setOnClickListener {
            val intent2 = Intent(this, FourthActivity::class.java).apply {
                putExtra("EXTRA_USERNAME", "Israel2800")
            }
            register.launch(intent2)
        }

        // Calling fifth activity
        btnSendActivity5.setOnClickListener {
            val intent3 = Intent(this, FifthActivity::class.java).apply {
            }
            register.launch(intent3)
        }
    }
}