package com.ghamsari.rcontacts.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghamsari.rcontacts.R
import com.ghamsari.rcontacts.model.contacts

class contactAdapter(private val dataSet :List<contacts>) :RecyclerView.Adapter<contactAdapter.viewHolder>() {
    class viewHolder(view :View) :RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactAdapter.viewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.contacts_recyclerview_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: contactAdapter.viewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }
}