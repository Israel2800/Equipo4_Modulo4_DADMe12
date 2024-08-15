package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.fragment.params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.FragmentReceiveUserDataBinding


class ReceiveUserDataFragment : Fragment() {

    private lateinit var binding : FragmentReceiveUserDataBinding
    private var userName : String? = ""
    private var password : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            userName = it.getString("ARG_USERNAME")
            password = it.getString("ARG_PASSWORD")
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
        binding.tvUserLoginInfo.text = "User name = $userName, Password = $password"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        @JvmStatic
        fun newInstance(userName:String, password:String) = ReceiveUserDataFragment().apply {
            arguments = Bundle().apply {
                putString("ARG_USERNAME", userName)
                putString("ARG_PASSWORD", password)
            }
        }
    }
}