package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val labelName = findViewById<TextView>(R.id.labelName)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        // Otra forma de representar it es: extras -> ------ if(extras.containsKey){}
        intent.extras?.let {
            if(it.containsKey("EXTRA_NAME_KEY")){
                val name = it.getString("EXTRA_NAME_KEY", "")
                labelName.text = name
            //Toast.makeText(this, "Mi nombre es: $name", Toast.LENGTH_SHORT).show()
            }
            if(it.containsKey("EXTRA_AGE_KEY")){
                val age = it.getInt("EXTRA_AGE_KEY", 0)
                Toast.makeText(this, "Mi edad es: $age", Toast.LENGTH_LONG).show()

            }
           /* val surname = it.getString("EXTRA_SURNAME", "")
            Toast.makeText(this, "Mi edad es: $age, mi apellido es: $surname", Toast.LENGTH_LONG).show()*/
            if(it.containsKey("EXTRA_OPTION")){
                val option = it.getBoolean("EXTRA_OPTION", true)
                Toast.makeText(this, "Mi opción es: $option", Toast.LENGTH_LONG).show()
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