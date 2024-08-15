package com.israelaguilar.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.databinding.FragmentReceiveUserDataBinding

class ReceiveUserDataFragment : Fragment() {

    private lateinit var binding: FragmentReceiveUserDataBinding

    // Sign-up data
    private var userName: String? = null
    private var userLastName: String? = null
    private var userTitle: String? = null
    private var userEmail: String? = null
    private var userSex: String? = null
    private var userPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            userName = it.getString("USER_NAME")
            userLastName = it.getString("USER_LASTNAME")
            userTitle = it.getString("USER_TITLE")
            userEmail = it.getString("USER_EMAIL")
            userSex = it.getString("USER_SEX")
            userPassword = it.getString("USER_PASSWORD")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReceiveUserDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set the user data to the TextViews
        binding.tvUserName.text = "Nombre: $userName"
        binding.tvUserLastName.text = "Apellido: $userLastName"
        binding.tvUserTitle.text = "Título: $userTitle"
        binding.tvUserEmail.text = "Correo electrónico: $userEmail"
        binding.tvUserPassword.text = "Contraseña: $userPassword"
        binding.tvUserSex.text = "Sexo: $userSex"
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
        fun newInstance(
            userName: String,
            userLastName: String,
            userTitle: String,
            userEmail: String,
            userSex: String,
            userPassword: String
        ) = ReceiveUserDataFragment().apply {
            arguments = Bundle().apply {
                putString("USER_NAME", userName)
                putString("USER_LASTNAME", userLastName)
                putString("USER_TITLE", userTitle)
                putString("USER_EMAIL", userEmail)
                putString("USER_SEX", userSex)
                putString("USER_PASSWORD", userPassword)
            }
        }

    }
}
