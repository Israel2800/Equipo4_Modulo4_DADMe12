package com.israelaguilar.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.israelaguilar.androidbasic12.R
import com.israelaguilar.androidbasic12.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentHomeScreen, LoginFragment.newInstance())
                .commit()

    }
}