package com.example.session_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BanksAdapter(var listBanks: List<Bank>) : RecyclerView.Adapter<BanksAdapter.BanksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BanksViewHolder {
        val element = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_bank, parent, false)

        return BanksViewHolder(element)
    }

    class BanksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val address: TextView = view.findViewById(R.id.text_view_address)
        val type: TextView = view.findViewById(R.id.text_view_bank_branch)
        val status: TextView = view.findViewById(R.id.text_view_work)
        val time: TextView = view.findViewById(R.id.text_view_time_work)
    }

    override fun onBindViewHolder(holder: BanksViewHolder, position: Int) {
        holder.address.text = listBanks[position].address
        holder.type.text = listBanks[position].type
        if (listBanks[position].status) {
            holder.status.text = "Работает"
        } else {
            holder.status.text = "Не работает"
        }
        holder.time.text = listBanks[position].time
    }

    override fun getItemCount(): Int = listBanks.size

    fun submitList(list: List<Bank>) {
        listBanks = list
    }
}