package com.israelaguilar.androidbasic12.ejerciciofinal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etUser: EditText = binding.etUser
        val etLastName: EditText = binding.etLastName
        val spinnerTitle: Spinner = binding.spinnerTitle
        val etEmail: EditText = binding.etEmail
        val rgSex: RadioGroup = binding.rgSex
        val etPassword: EditText = binding.etPassword
        val cbAcceptConditions: CheckBox = binding.cbAcceptConditions

        binding.btnSignUp.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.lightBlue))

        binding.btnSignUp.setOnClickListener {
            if (validateFields(etUser, etLastName, etEmail, rgSex, etPassword, cbAcceptConditions)) {
                // Obtener información del formulario
                val userName = etUser.text.toString()
                val userLastName = etLastName.text.toString()
                val userTitle = spinnerTitle.selectedItem.toString()
                val userEmail = etEmail.text.toString()
                val userSex = view.findViewById<RadioButton>(rgSex.checkedRadioButtonId)?.text.toString()
                val userPassword = etPassword.text.toString()

                // Iniciar HomeScreenActivity
                val intent = Intent(activity, HomeScreenActivity::class.java).apply {
                    putExtra("USER_NAME", userName)
                    putExtra("USER_LASTNAME", userLastName)
                    putExtra("USER_TITLE", userTitle)
                    putExtra("USER_EMAIL", userEmail)
                    putExtra("USER_SEX", userSex)
                    putExtra("USER_PASSWORD", userPassword)
                }
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

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

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_item)
        }

        spinnerTitle.adapter = adapter
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
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}
