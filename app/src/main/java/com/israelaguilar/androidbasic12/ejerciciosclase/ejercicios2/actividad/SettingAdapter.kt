package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.actividad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.androidbasic12.R

class SettingAdapter(val list:List<SettingEntity>):RecyclerView.Adapter<SettingAdapter.SettingViewHolder>() {

    class SettingViewHolder(view: View): RecyclerView.ViewHolder(view){

        val ivSetting = view.findViewById<ImageView>(R.id.ivSetting)
        val tvSetting  = view.findViewById<TextView>(R.id.tvSetting)

        fun render(settingEntity: SettingEntity) {
            tvSetting.text = settingEntity.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_setting,parent,false)
        return SettingViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        holder.render(list[position])
    }

}