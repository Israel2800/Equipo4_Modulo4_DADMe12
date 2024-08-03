package com.israelaguilar.androidbasic12.ejerciciosclase.ejercicios2.componentesgraficos.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.israelaguilar.androidbasic12.R

class PersonAdapter(val list: List<PersonEntity>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(view:View): RecyclerView.ViewHolder(view){
        val ivPersonImage = view.findViewById<ImageView>(R.id.ivPersonImage)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvLastName = view.findViewById<TextView>(R.id.tvLastName)

        fun render(personEntity: PersonEntity) {
            tvName.text = personEntity.name
            tvLastName.text = personEntity.lastName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.render(list[position])
    }

}