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

        var btnSendActivity = findViewById<Button>(R.id.btnSendActivity)

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

        // Calling fourth activity
        /*var btnSendActivity4 = findViewById<Button>(btnSendActivity4)

        btnSendActivity4.setOnClickListener {
            val intent2 = Intent(this, FourthActivity::class.java).apply {

            }

            register.launch(intent2)
        }*/
    }
}