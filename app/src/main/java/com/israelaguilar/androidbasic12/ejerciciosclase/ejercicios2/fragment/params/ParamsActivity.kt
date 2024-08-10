package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.fragment.params

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.ActivityFragmentBinding
import com.israelaguilar.androidbasic12.databinding.ActivityParamsBinding

class ParamsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityParamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentParams, SendParamsFragment.newInstance())
            .commit()
    }
}