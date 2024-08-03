package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R

class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)

        val btnGetInfo = findViewById<Button>(R.id.btnGetInfo)
        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val etName = findViewById<EditText>(R.id.etName)

        //CHECKBOX
        cbCreditCard.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                rgSex.visibility = View.GONE
            }else{
                rgSex.visibility = View.VISIBLE
            }

            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //RADIOGROUP
        rgSex.setOnCheckedChangeListener { radioGroup, id ->
            val idName = getRgLabel(id, false)
            Toast.makeText(this, "CheckedId: $idName", Toast.LENGTH_SHORT).show()
        }

        //SPINNER
        val data = arrayListOf("No selección", "México", "Colombia", "Canada", "Argentina", "Dinamarca", "Venezuela", "España")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = data[position]

                if(position == 0){
                    Toast.makeText(this@ComponentsActivity, "Item no seleccionado: ", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@ComponentsActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_LONG).show()

                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@ComponentsActivity, "Nada seleccionado: ", Toast.LENGTH_LONG).show()
            }

        }

        btnGetInfo.setOnClickListener {
            val cbStatus = cbCreditCard.isChecked
            val selectedRgOption = getRgLabel(rgSex.checkedRadioButtonId, true)
            val itemSpinnerSelected = spinner.selectedItem

            if(etName.text.toString().isEmpty()) {
                Toast.makeText(this, "isChecked = $cbStatus y checkedId = $selectedRgOption, selectedSpinnerItem = $itemSpinnerSelected, name = ${etName.text.toString()}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Debes ingresar tu nombre", Toast.LENGTH_SHORT).show()
            }
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