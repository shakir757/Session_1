package com.example.session_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class BanksAdapter : RecyclerView.Adapter<BanksAdapter.BanksViewHolder>(){
    class BanksViewHolder(val element: ConstraintLayout) : RecyclerView.ViewHolder(element)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BanksViewHolder {
        val element = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_bank, parent, false) as ConstraintLayout

        return BanksViewHolder(element)
    }

    override fun onBindViewHolder(holder: BanksViewHolder, position: Int) {

    }

    override fun getItemCount() = 15
}