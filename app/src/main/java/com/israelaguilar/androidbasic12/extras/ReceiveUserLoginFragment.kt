package com.israelaguilar.androidbasic12.extras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.databinding.FragmentReceiveUserLoginBinding


class ReceiveUserLoginFragment : Fragment() {

    private lateinit var binding : FragmentReceiveUserLoginBinding

    // Login in data
    private var email: String? = ""
    private var password: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            email = it.getString("ARG_EMAIL")
            password = it.getString("ARG_PASSWORD")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentReceiveUserLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tvUserEmail.text = "Correo electrónico: $email"
        binding.tvUserPassword.text = "Contraseña: $password"

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
        fun newInstance(
            email: String,
            password: String
        ) = ReceiveUserLoginFragment().apply {
            arguments = Bundle().apply {
                putString("ARG_EMAIL", email)
                putString("ARG_PASSWORD", password)
            }
        }
    }
}