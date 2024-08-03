package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R

class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)

        val btnGetInfo = findViewById<Button>(R.id.btnGetInfo)
        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)


        cbCreditCard.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                rgSex.visibility = View.GONE
            }else{
                rgSex.visibility = View.VISIBLE
            }

            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        rgSex.setOnCheckedChangeListener { radioGroup, id ->
            val idName = getRgLabel(id, false)
            Toast.makeText(this, "CheckedId: $idName", Toast.LENGTH_SHORT).show()
        }

        btnGetInfo.setOnClickListener {
            val cbStatus = cbCreditCard.isChecked
            val selectedRgOption = getRgLabel(rgSex.checkedRadioButtonId, true)
            Toast.makeText(this, "isChecked = $cbStatus y checkedId = $selectedRgOption", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getRgLabel(id:Int, isFromButton: Boolean): String{
        return when(id){
            R.id.rbWoman -> {
                if(isFromButton) "M" else "Mujer"
            }
            R.id.rbMan -> {
                if(isFromButton) "H" else "Hombre"
            }
            else -> "Desconocida"
        }

    }
}