package com.example.session_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ValutesAdapter : RecyclerView.Adapter<ValutesAdapter.MyViewHolder>() {

    class MyViewHolder(val element: ConstraintLayout) : RecyclerView.ViewHolder(element)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValutesAdapter.MyViewHolder {
        val element = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_valute, parent, false) as ConstraintLayout

        return MyViewHolder(element)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount() = 15
}