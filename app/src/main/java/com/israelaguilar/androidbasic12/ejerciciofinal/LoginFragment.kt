package com.israelaguilar.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.btnLogin.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if(email.isNotEmpty()){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentHomeScreen, ReceiveUserLoginFragment.newInstance(email, password))
                    .addToBackStack("ReceiveUserLoginFragment")
                    .commit()
            }
        }

        binding.tvRegistro.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentHomeScreen, SignUpFragment.newInstance())
                .commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}