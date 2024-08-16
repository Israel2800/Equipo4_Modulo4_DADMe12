package com.israelaguilar.androidbasic12.ejerciciofinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        /*binding.btnLogin.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if(email.isNotEmpty()){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.mainFragment, ReceiveUserLoginFragment.newInstance(email, password))
                    .addToBackStack("ReceiveUserLoginFragment")
                    .commit()
            }
        }*/

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty()) {
                // Iniciar HomeScreenActivity con los datos ingresados
                val intent = Intent(activity, HomeScreenActivity::class.java).apply {
                    putExtra("ARG_EMAIL", email)
                    putExtra("ARG_PASSWORD", password)
                }
                startActivity(intent)
            }else{
                Toast.makeText(activity, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegistro.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragment, SignUpFragment.newInstance())
                .commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}