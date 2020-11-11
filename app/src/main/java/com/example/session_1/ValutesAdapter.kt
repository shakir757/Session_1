package com.example.session_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_item_valute.view.*

class ValutesAdapter(var listVolutes : List<Valute>) : RecyclerView.Adapter<ValutesAdapter.ValutesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValutesViewHolder {
        val element = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_valute, parent, false)

        return ValutesViewHolder(element)
    }

    /*class ValutesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }*/

    override fun onBindViewHolder(holder: ValutesViewHolder, position: Int) {
        holder.bind(listVolutes[position])
    }

    override fun getItemCount(): Int = listVolutes.size

    class ValutesViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bind(valute: Valute){
            itemView.text_view_valute_name.text = valute.charCode
            itemView.text_view_valute_full_name.text = valute.name
            itemView.text_view_valute_buy.text = valute.currencyValue.toString()
            itemView.text_view_valute_sale.text = (valute.currencyValue - 1).toString()

            if (valute.currencyValue > valute.currencyPrevisionValue){
                itemView.image_view_up_dow_buy.setImageResource(R.drawable.up)
                itemView.image_view_up_dow_sale.setImageResource(R.drawable.up)
            } else {
                itemView.image_view_up_dow_buy.setImageResource(R.drawable.down)
                itemView.image_view_up_dow_sale.setImageResource(R.drawable.down)
            }
        }
    }

    fun submitList(list: List<Valute>) {
        listVolutes = list
    }
}