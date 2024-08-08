package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.actividad

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.androidbasic12.R

class ConfigurationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = findViewById<RecyclerView>(R.id.settingsList)

        val data = listOf(
            SettingEntity("Cuenta",""),
            SettingEntity("Privacidad",""),
            SettingEntity("Notificaciones",""),
            SettingEntity("Almacenamiento",""),
            SettingEntity("Ayuda","")
        )


        val adapter = SettingAdapter(data)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                onBackPressedDispatcher.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}