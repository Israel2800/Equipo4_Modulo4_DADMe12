package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.fragment.params

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.FragmentSendParamsBinding
import com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios1.explicitintent.HomeActivity
import com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.fragment.SecondFragment


class SendParamsFragment : Fragment() {

    private lateinit var binding : FragmentSendParamsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSendParamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.btnSendParams.setOnClickListener {

            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString()

            if(name.isNotEmpty()){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentParams, ReceiveParamsFragment.newInstance(name, age.toInt()+0))
                    .addToBackStack("ReceiveParamsFragment")
                    .commit()
            }

            // Mandando a llamar a otra activity con un intent
            /*val intent = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(intent)*/

        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}