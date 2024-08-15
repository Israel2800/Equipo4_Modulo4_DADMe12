package com.israelaguilar.androidbasic12.ejerciciofinal

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

        binding.btnSignUp.setOnClickListener {
            if (validateFields(etUser, etLastName, etEmail, rgSex, etPassword, cbAcceptConditions)) {
                // Get the data from the form
                val userName = etUser.text.toString()
                val userLastName = etLastName.text.toString()
                val userTitle = spinnerTitle.selectedItem.toString()
                val userEmail = etEmail.text.toString()
                val userSex = view?.findViewById<RadioButton>(rgSex.checkedRadioButtonId)?.text.toString()
                val userPassword = etPassword.text.toString()

                // Create the new fragment instance with the data passed as arguments
                /*val ReceiveUserDataFragment = ReceiveUserDataFragment.newInstance(
                    userName = userName,
                    userLastName = userLastName,
                    userTitle = userTitle,
                    userEmail = userEmail,
                    userSex = userSex,
                    userPassword = userPassword
                )*/

                // Navigate to the ReceiveUserDataFragment
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentHomeScreen, ReceiveUserDataFragment.newInstance(userName, userLastName, userTitle, userEmail, userSex, userPassword))
                    .addToBackStack("ReceiveUserDataFragment")
                    .commit()
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
        when(item.itemId){
            android.R.id.home -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
                //Toast.makeText(this, "Click in back", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}
