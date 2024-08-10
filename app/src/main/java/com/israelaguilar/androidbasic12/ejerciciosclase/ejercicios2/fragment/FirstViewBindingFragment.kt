package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.FragmentFirstViewBindingBinding


class FirstViewBindingFragment : Fragment() {

    private lateinit var binding: FragmentFirstViewBindingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstViewBindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnText.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, SecondFragment.newInstance())
                .addToBackStack("SecondFragment")
                .commit()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstViewBindingFragment()
    }
}