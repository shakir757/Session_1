package com.example.session_1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import kotlin.math.pow

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val element: ConstraintLayout) : RecyclerView.ViewHolder(element)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val element = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_valute, parent, false) as ConstraintLayout

        return MyViewHolder(element)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount() = 15
}