package com.israelaguilar.androidbasic12.tarea.itzel

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R

class SingUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etName: EditText = findViewById(R.id.etName)
        val etLName: EditText = findViewById(R.id.etLName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val cbTermsAndConds : CheckBox = findViewById(R.id.cbTermsAnsConds)
        val spinnerMonth : Spinner = findViewById(R.id.spinnerMonth)
        val btnSingUp : Button = findViewById((R.id.btnSignUp))

        val spinnerMonthData = findViewById<Spinner>(R.id.spinnerMonth)

        val data = arrayListOf(
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_item)
        }
        spinnerMonthData.adapter = adapter

        btnSingUp.setOnClickListener {
            if(validateInfo(etName,etLName,etEmail,etPassword,rgGender,cbTermsAndConds)){
                val name = etName.text.toString()
                val lastname = etLName.text.toString()
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val month = spinnerMonth.selectedItem.toString()
                val gender = findViewById<RadioButton>(rgGender.checkedRadioButtonId)?.text.toString()


                val intent = Intent(this, DataDisplayActivity::class.java).apply {
                    putExtra("USER_NAME", name)
                    putExtra("USER_LASTNAME", lastname)
                    putExtra("USER_EMAIL", email)
                    putExtra("USER_PASSWORD", password)
                    putExtra("USER_GENDER", gender)
                    putExtra("USER_MONTH", month)

                }
                startActivity(intent)

            }else{
                Toast.makeText(this, "Debe llenar todos los campos antes de continuar", Toast.LENGTH_SHORT).show()
            }
        }



    }

    private fun validateInfo(
        etName:EditText,
        etLName:EditText,
        etEmail:EditText,
        etPassword:EditText,
        rgGender:RadioGroup,
        cbTermsAndConds:CheckBox):
        Boolean{
            return etName.text.isNotEmpty() &&
                    etLName.text.isNotEmpty() &&
                    etEmail.text.isNotEmpty() &&
                    etPassword.text.isNotEmpty() &&
                    rgGender.checkedRadioButtonId != -1 &&
                    cbTermsAndConds.isChecked

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}