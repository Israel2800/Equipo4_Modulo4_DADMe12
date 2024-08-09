package com.israelaguilar.androidbasic12.tarea.israel

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R

class UserSignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_sign_up)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etUser: EditText = findViewById(R.id.etUser)
        val etLastName: EditText = findViewById(R.id.etLastName)
        val spinnerTitle: Spinner = findViewById(R.id.spinnerTitle)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val rgSex: RadioGroup = findViewById(R.id.rgSex)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val cbAcceptConditions: CheckBox = findViewById(R.id.cbAcceptConditions)
        val btnSignUp: Button = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            if(validateFields(etUser, etLastName, etEmail, rgSex, etPassword, cbAcceptConditions)){
                // Obtener la información del formulario
                val userName = etUser.text.toString()
                val userLastName = etLastName.text.toString()
                val userTitle = spinnerTitle.selectedItem.toString()
                val userEmail = etEmail.text.toString()
                val userSex = findViewById<RadioButton>(rgSex.checkedRadioButtonId)?.text.toString()
                val userPassword = etPassword.text.toString()

                // Intent para pasar la información obtenida a la siguiente vista
                val intent = Intent(this, UserDataActivity::class.java).apply {
                    putExtra("USER_NAME", userName)
                    putExtra("USER_LASTNAME", userLastName)
                    putExtra("USER_TITLE", userTitle)
                    putExtra("USER_EMAIL", userEmail)
                    putExtra("USER_SEX", userSex)
                    putExtra("USER_PASSWORD", userPassword)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }


        val spinnerTitleData = findViewById<Spinner>(R.id.spinnerTitle)

        val data = arrayListOf(
            "No selección",
            "Sr.",
            "Sra.",
            "Srta.",
            "Dr.",
            "Dra.",
            "Lic.",
            "Ing.",
            "Arq.",
            "Prof."
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_item)
        }

        spinnerTitleData.adapter = adapter

    }

    private fun validateFields(
        etUser: EditText,
        etLastName: EditText,
        etEmail: EditText,
        rgSex: RadioGroup,
        etPassword: EditText,
        cbAcceptConditions: CheckBox
    ): Boolean {
        return etUser.text.isNotEmpty() &&
                etLastName.text.isNotEmpty() &&
                etEmail.text.isNotEmpty() &&
                rgSex.checkedRadioButtonId != -1 &&
                etPassword.text.isNotEmpty() &&
                cbAcceptConditions.isChecked
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