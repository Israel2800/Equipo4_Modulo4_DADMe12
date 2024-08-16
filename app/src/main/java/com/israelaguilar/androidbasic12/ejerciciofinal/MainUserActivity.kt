package com.israelaguilar.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.ActivityHomeScreenBinding
import com.israelaguilar.androidbasic12.databinding.ActivityMainUserBinding

class MainUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

            supportFragmentManager.beginTransaction()
                .add(R.id.mainFragment, LoginFragment.newInstance())
                .commit()

    }
}