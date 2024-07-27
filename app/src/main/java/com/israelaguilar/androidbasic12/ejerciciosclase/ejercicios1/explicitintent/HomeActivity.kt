package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var btnSendActivity = findViewById<Button>(R.id.btnSendActivity)

        btnSendActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Israel")
                putExtra("EXTRA_AGE_KEY", 23)
            }

            register.launch(intent)
            // startActivity(intent)
        }
    }
}